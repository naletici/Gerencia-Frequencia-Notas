package src.main;
public class TrabalhoPratico extends Avaliacao {
    private double peso;

    public TrabalhoPratico(String nomeAvaliacao, double notaObtida, double peso) {
        super(nomeAvaliacao, notaObtida);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calcularNotaTotal() {
        return getNotaObtida() * peso;
    }
}
