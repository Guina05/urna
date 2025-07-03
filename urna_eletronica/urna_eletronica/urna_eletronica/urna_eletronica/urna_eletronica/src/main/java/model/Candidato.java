package model;

/**
 *
 * @author leuma
 */
public class Candidato {
    private String numero;
    private String nome;
    private String partido;
    
    //construtor
    public Candidato(String numero, String nome, String partido) {
        this.numero = numero;
        this.nome = nome;
        this.partido = partido;
    }

    // Get e set
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    // Método toString
    @Override
    public String toString() {
        return "Candidato{" +
                "numero='" + numero + '\'' +
                ", nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                '}';
    }
    
}
