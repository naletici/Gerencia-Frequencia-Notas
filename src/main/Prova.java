package main;
/**
 * Classe que representa uma prova
 * Prova
 */
public class Prova extends Avaliacao {
    /**
     * Construtor da classe Prova
     * @param nomeAvaliacao O nome da prova
     * @param notaObtida A nota obtida na prova
     */
    public Prova(String nomeAvaliacao, double notaObtida) {
        super(nomeAvaliacao, notaObtida);
    }
    /**
     * Método para calcular a nota total da prova
     * @return A nota obtida na prova
     */
    @Override
    public double calcularNotaTotal() {
        return getNotaObtida();
    }
}
