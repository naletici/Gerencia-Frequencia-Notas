package src.main;
/**
 * Classe abstrata que representa uma avaliação qualquer de um aluno
 * Avaliacao
 */
public abstract class Avaliacao {
    private String nomeAvaliacao;
    private double notaObtida;
    /**
     * Construtor da classe Avaliacao
     * @param nomeAvaliacao O nome da avaliação
     * @param notaObtida A nota obtida na avaliação
     */
    public Avaliacao(String nomeAvaliacao, double notaObtida) {
        this.nomeAvaliacao = nomeAvaliacao;
        validarNota(notaObtida);
        this.notaObtida = notaObtida;
    }
    /**
     * Método abstrato para calcular a nota total da avaliação
     * @return A nota total, calculada conforme o tipo de avaliação
     */
    public abstract double calcularNotaTotal();
    /**
     * Método para validar se uma nota está dentro do intervalo permitido
     * @param nota A nota deve ser validada
     * @throws NotaInvalidaException se a nota estiver fora do intervalo (0, 10)
     */
    protected void validarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new NotaInvalidaException("A nota deve estar entre 0.0 e 10.0.");
        }
    }
    /**
     * Método para obter o nome da avaliação
     * @return O nome da avaliação
     */
    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }
    /**
     * Método para definir o nome da avaliação
     * @param nomeAvaliacao O nome a ser atribuído
     */
    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }
    /**
     * Método para obter a nota obtida na avaliação
     * @return A nota obtida
     */
    public double getNotaObtida() {
        return notaObtida;
    }
    /**
     * Método para definir a nota obtida na avaliação
     * @param notaObtida A nota a ser atribuída
     */
    public void setNotaObtida(double notaObtida) {
        validarNota(notaObtida);
        this.notaObtida = notaObtida;
    }
}
