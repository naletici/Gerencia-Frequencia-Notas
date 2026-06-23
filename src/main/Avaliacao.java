package src.main;
public abstract class Avaliacao {
    private String nomeAvaliacao;
    private double notaObtida;

    public Avaliacao(String nomeAvaliacao, double notaObtida) {
        this.nomeAvaliacao = nomeAvaliacao;
        validarNota(notaObtida);
        this.notaObtida = notaObtida;
    }
  
    public abstract double calcularNotaDefinitiva();

    protected void validarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new NotaInvalidaException("A nota deve estar entre 0.0 e 10.0.");
        }
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    public double getNotaObtida() {
        return notaObtida;
    }

    public void setNotaObtida(double notaObtida) {
        validarNota(notaObtida);
        this.notaObtida = notaObtida;
    }
}
