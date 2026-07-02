package src.main;
/**
 * Classe abstrata que representa um membro acadêmico (Aluno ou Professor)
 * MembroAcademico
 */
public abstract class MembroAcademico {
    private String nome;
    private String matricula;
    /**
     * Construtor padrão da classe MembroAcademico
     */
    public MembroAcademico() {}
    /**
    * Construtor da classe MembroAcademico
    * @param nome O nome do membro acadêmico
    * @param matricula A matrícula do membro acadêmico
    */
    public MembroAcademico(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    /**
     * Método para obter o nome do membro acadêmico
     * @return O nome do membro acadêmico
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método para definir o nome do membro acadêmico
     * @param nome O nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Método para obter a matrícula do membro acadêmico
     * @return A matrícula do membro acadêmico
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Método para definir a matrícula do membro acadêmico
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
