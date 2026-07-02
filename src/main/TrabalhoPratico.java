package main;
/**
 * Classe que representa um trabalho prático, no qual a nota total é a nota obtida multiplicada pelo peso
 */
public class TrabalhoPratico extends Avaliacao {
    private double peso;
    /**
     * Construtor da classe TrabalhoPratico
     * @param nomeAvaliacao O nome do trabalho
     * @param notaObtida A nota obtida no trabalho
     * @param peso O peso aplicado à nota do trabalho
     */
    public TrabalhoPratico(String nomeAvaliacao, double notaObtida, double peso) {
        super(nomeAvaliacao, notaObtida);
        this.peso = peso;
    }
    /**
     * Método para obter o peso do trabalho
     * @return O peso do trabalho
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Método para definir o peso do trabalho
     * @param peso O peso a ser atribuído
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    /**
     * Método para calcular a nota total do trabalho
     * @return A nota obtida multiplicada pelo peso
     */
    @Override
    public double calcularNotaTotal() {
        return getNotaObtida() * peso;
    }
}
