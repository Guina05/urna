package model;

/**
 *
 * @author leuma
 */
public class Voto {
    private String numeroCandidato;
    private String tipo; // "VALIDO", "BRANCO", "NULO"

    // Construtor
    public Voto(String numeroCandidato, String tipo) {
        this.numeroCandidato = numeroCandidato;
        this.tipo = tipo;
    }

    // Get e Set
    public String getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(String numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    // Método toString
    @Override
    public String toString() {
        return "Voto{" +
                "numeroCandidato='" + numeroCandidato + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    // Métodos estáticos para tipos de voto
    public static final String TIPO_VALIDO = "VALIDO";
    public static final String TIPO_BRANCO = "BRANCO";
    public static final String TIPO_NULO = "NULO";
    
}
