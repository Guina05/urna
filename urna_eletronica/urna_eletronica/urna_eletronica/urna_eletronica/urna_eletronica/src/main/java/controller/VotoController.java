package controller;

import model.Voto;
import comum.conexaoMongo;
import org.bson.Document;
import model.Candidato;
import java.util.*;
import java.util.stream.Collectors;

public class VotoController {
    
    private static final String COLECAO_VOTOS = "votos";
    private static final String COLECAO_CANDIDATOS = "candidatos";
    private static final String COLECAO_PARTIDOS = "partidos";
    private final CandidatoController candidatoController;
    
    public VotoController() {
        this.candidatoController = new CandidatoController();
        criarIndices();
    }
    
    private void criarIndices() {
        try {
            conexaoMongo.getDatabase()
                .getCollection(COLECAO_CANDIDATOS)
                .createIndex(new Document("numero", 1));
            
            conexaoMongo.getDatabase()
                .getCollection(COLECAO_VOTOS)
                .createIndex(new Document("tipo", 1));
                
            conexaoMongo.getDatabase()
                .getCollection(COLECAO_PARTIDOS)
                .createIndex(new Document("numero", 1));
        } catch (Exception e) {
            System.err.println("Erro ao criar índices: " + e.getMessage());
        }
    }
    
    public boolean registrarVoto(Voto voto) {
        try {
            Document doc = new Document()
                .append("numeroCandidato", voto.getNumeroCandidato())
                .append("tipo", voto.getTipo());
            
            conexaoMongo.getDatabase()
                .getCollection(COLECAO_VOTOS)
                .insertOne(doc);
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao registrar voto: " + e.getMessage());
            return false;
        }
    }
    
    public boolean registrarVotoValido(String numeroCandidato) {
        return registrarVoto(new Voto(numeroCandidato, Voto.TIPO_VALIDO));
    }
    
    public boolean registrarVotoBranco() {
        return registrarVoto(new Voto("BRANCO", Voto.TIPO_BRANCO));
    }
    
    public boolean registrarVotoNulo(String numeroDigitado) {
        return registrarVoto(new Voto(numeroDigitado, Voto.TIPO_NULO));
    }
    
    public boolean candidatoExiste(String numeroCandidato) {
        return buscarCandidatoPorNumero(numeroCandidato) != null;
    }
    
    public Candidato getCandidato(String numeroCandidato) {
        return buscarCandidatoPorNumero(numeroCandidato);
    }
     
    public Candidato buscarCandidatoPorNumero(String numeroCompleto) {
        try {
            Document query = new Document("numero", numeroCompleto);
            Document candidatoDoc = conexaoMongo.getDatabase()
                .getCollection(COLECAO_CANDIDATOS)
                .find(query)
                .first();
                
            if (candidatoDoc != null) {
                return new Candidato(
                    candidatoDoc.getString("numero"),
                    candidatoDoc.getString("nome"),
                    candidatoDoc.getString("partido")
                );
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar candidato por número: " + e.getMessage());
        }
        return null;
    }
    
    //Busca candidatos que começam com o número parcial digitado
    public Candidato buscarCandidatoPorNumeroParcial(String numeroParcial) {
        try {
            Document query = new Document("numero", 
                new Document("$regex", "^" + numeroParcial));
            
            Document candidatoDoc = conexaoMongo.getDatabase()
                .getCollection(COLECAO_CANDIDATOS)
                .find(query)
                .first();
                
            if (candidatoDoc != null) {
                return new Candidato(
                    candidatoDoc.getString("numero"),
                    candidatoDoc.getString("nome"),
                    candidatoDoc.getString("partido")
                );
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar candidato por número parcial: " + e.getMessage());
        }
        return null;
    }
    
    // Busca o partido correspondente aos primeiros dígitos do número
    public String buscarPartidoPorNumero(String numeroPartido) {
        try {
            // Primeiro tenta buscar na coleção de partidos
            Document partidoDoc = conexaoMongo.getDatabase()
                .getCollection(COLECAO_PARTIDOS)
                .find(new Document("numero", numeroPartido))
                .first();
                
            if (partidoDoc != null) {
                return partidoDoc.getString("sigla");
            }
            
            // Se não encontrar, busca pelo partido de um candidato com esse prefixo
            Document candidatoDoc = conexaoMongo.getDatabase()
                .getCollection(COLECAO_CANDIDATOS)
                .find(new Document("numero", new Document("$regex", "^" + numeroPartido)))
                .first();
                
            if (candidatoDoc != null) {
                return candidatoDoc.getString("partido");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar partido por número: " + e.getMessage());
        }
        return null;
    }
    
    public String gerarRelatorioFormatado() {
        try {
            int totalGeral = contarTodosVotos();
            if (totalGeral == 0) return "Nenhum voto registrado ainda";
            
            List<Document> votacao = getVotacaoCandidatos();
            Map<String, String> nomes = getNomesCandidatos();
            int brancos = contarVotosPorTipo(Voto.TIPO_BRANCO);
            int nulos = contarVotosPorTipo(Voto.TIPO_NULO);
            
            return formatarRelatorio(votacao, nomes, brancos, nulos, totalGeral);
        } catch (Exception e) {
            return "Erro ao gerar relatório: " + e.getMessage();
        }
    }
    
    private List<Document> getVotacaoCandidatos() {
        try {
            return conexaoMongo.getDatabase()
                .getCollection(COLECAO_VOTOS)
                .aggregate(Arrays.asList(
                    new Document("$match", 
                        new Document("tipo", Voto.TIPO_VALIDO)),
                    new Document("$group", 
                        new Document("_id", "$numeroCandidato")
                               .append("votos", new Document("$sum", 1))),
                    new Document("$sort", new Document("votos", -1))
                )).into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Erro ao obter votação: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    
    private Map<String, String> getNomesCandidatos() {
        try {
            return conexaoMongo.getDatabase()
                .getCollection(COLECAO_CANDIDATOS)
                .find()
                .into(new ArrayList<>())
                .stream()
                .collect(Collectors.toMap(
                    doc -> doc.getString("numero"),
                    doc -> doc.getString("nome"),
                    (existing, replacement) -> existing));
        } catch (Exception e) {
            System.err.println("Erro ao obter nomes: " + e.getMessage());
            return Collections.emptyMap();
        }
    }
    
    private String formatarRelatorio(List<Document> votacao, 
                                   Map<String, String> nomes, 
                                   int brancos, 
                                   int nulos, 
                                   int totalGeral) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RESULTADO DA ELEIÇÃO ===\n\n");
        relatorio.append("POS.  CANDIDATO                     VOTOS     %\n");
        relatorio.append("-----------------------------------------------\n");
        
        int posicao = 1;
        for (Document doc : votacao) {
            String numero = doc.getString("_id");
            int votos = doc.getInteger("votos");
            double percentual = (votos * 100.0) / totalGeral;
            String nome = nomes.getOrDefault(numero, "Candidato Desconhecido");
            
            relatorio.append(String.format("%-5d %-30s %-10d %.1f%%\n",
                posicao++, 
                nome + " (" + numero + ")", 
                votos, 
                percentual));
        }
        
        relatorio.append("\nTOTAIS:\n");
        relatorio.append(String.format("Votos válidos: %d (%.1f%%)\n",
            totalGeral - brancos - nulos,
            ((totalGeral - brancos - nulos) * 100.0) / totalGeral));
            
        relatorio.append(String.format("Votos em branco: %d (%.1f%%)\n",
            brancos,
            (brancos * 100.0) / totalGeral));
            
        relatorio.append(String.format("Votos nulos: %d (%.1f%%)\n",
            nulos,
            (nulos * 100.0) / totalGeral));
            
        relatorio.append(String.format("\nTOTAL GERAL: %d votos\n", totalGeral));
        
        return relatorio.toString();
    }
    
    private int contarVotosPorTipo(String tipo) {
        try {
            return (int) conexaoMongo.getDatabase()
                .getCollection(COLECAO_VOTOS)
                .countDocuments(new Document("tipo", tipo));
        } catch (Exception e) {
            System.err.println("Erro ao contar votos: " + e.getMessage());
            return 0;
        }
    }
    
    private int contarTodosVotos() {
        try {
            return (int) conexaoMongo.getDatabase()
                .getCollection(COLECAO_VOTOS)
                .countDocuments();
        } catch (Exception e) {
            System.err.println("Erro ao contar total de votos: " + e.getMessage());
            return 0;
        }
    }
}