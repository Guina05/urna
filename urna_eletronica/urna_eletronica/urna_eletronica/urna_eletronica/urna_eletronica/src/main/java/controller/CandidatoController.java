package controller;

import model.Candidato;
import comum.conexaoMongo;
import org.bson.Document;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

public class CandidatoController {
    private static final String COLLECTION_NAME = "candidatos";
    
    public boolean cadastrarCandidato(Candidato candidato) {
        try {
            // Validação 
            if (candidato == null || candidato.getNumero() == null || 
                candidato.getNome() == null || candidato.getPartido() == null) {
                System.out.println("Dados do candidato inválidos");
                return false;
            }
            
            MongoCollection<Document> collection = conexaoMongo.getDatabase()
                .getCollection(COLLECTION_NAME);
            
            // Verifica se candidato já existe
            if (collection.find(new Document("numero", candidato.getNumero())).first() != null) {
                System.out.println("Candidato já existe: " + candidato.getNumero());
                return false;
            }
            
            // Cria e insere o documento
            Document doc = new Document()
                .append("numero", candidato.getNumero())
                .append("nome", candidato.getNome())
                .append("partido", candidato.getPartido());
            
            collection.insertOne(doc);
            return true;
            
        } catch (MongoException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
            return false;
        }
    }
    
    public Candidato buscarCandidato(String numero) throws MongoException {
        if (numero == null || numero.trim().isEmpty()) {
            return null;
        }
        
        Document doc = conexaoMongo.getDatabase()
            .getCollection(COLLECTION_NAME)
            .find(new Document("numero", numero))
            .first();
        
        if (doc != null) {
            return new Candidato(
                doc.getString("numero"),
                doc.getString("nome"),
                doc.getString("partido")
            );
        }
        return null;
    }
    
    public boolean candidatoExiste(String numero) throws MongoException {
        if (numero == null || numero.trim().isEmpty()) {
            return false;
        }
        
        Document doc = conexaoMongo.getDatabase()
            .getCollection(COLLECTION_NAME)
            .find(new Document("numero", numero))
            .first();
        
        return doc != null;
    }
}