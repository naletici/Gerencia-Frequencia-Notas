package src.main;
public class Prova extends Avaliacao {
    public Prova(String nomeAvaliacao, double notaObtida) {
        super(nomeAvaliacao, notaObtida);
    }

    @Override
    public double calcularNotaTotal() {
        return getNotaObtida();
    }
}
