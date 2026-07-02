package main;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa uma turma, agregando matéria, o professor e os alunos matriculados
 * Turma
 */
public class Turma {
    private Materia materia;
    private Professor professor;
    private List<Aluno> listaAlunos = new ArrayList<>();
    /**
     * Método para matricular um aluno na turma (alunos nulos são ignorados)
     * @param aluno O aluno a ser matriculado
     */
    public void matricularAluno(Aluno aluno) {
        if (aluno != null) {
            listaAlunos.add(aluno);
        }
    }
    /**
     * Método para remover um aluno da turma pelo índice
     * @param indice O índice do aluno na lista
     * @return true se o aluno foi removido, ou false se o índice era inválido
     */
    public boolean removerAluno(int indice) {
        if (indice >= 0 && indice < listaAlunos.size()) {
            listaAlunos.remove(indice);
            return true;
        }
        return false;
    }
    /**
     * Método para remover matéria da turma
     */
    public void removerMateria() {
        this.materia = null;
    }
    /**
     * Método para remover o professor da turma
     */
    public void removerProfessor() {
        this.professor = null;
    }
    /**
     * Método para listar a matéria da turma com carga horária, limite de faltas e alunos matriculados
     */
    public void listarMaterias() {
        System.out.println("\n=== LISTAGEM DE MATÉRIAS ===");
 
        if (materia == null) {
            System.out.println("[AVISO] Nenhuma matéria cadastrada na turma.");
            return;
        }
 
        System.out.printf("Matéria : %s\n", materia.getNomeMateria());
        System.out.printf("Carga Horária: %dh\n", materia.getCargaHorariaTotal());
        System.out.printf("Limite de Faltas: %.0f aulas\n", materia.getCargaHorariaTotal() * 0.25);
 
        System.out.println("Alunos matriculados:");
        if (listaAlunos.isEmpty()) {
            System.out.println("  - Nenhum aluno matriculado.");
        } else {
            for (Aluno a : listaAlunos) {
                System.out.printf("  - %s (Matrícula: %s) | Faltas: %d\n",
                        a.getNome(), a.getMatricula(), a.getFaltas());
            }
        }
        System.out.println("============================");
    }
    /**
     * Método para listar o professor da turma e a matéria que ele leciona
     */
    public void listarProfessores() {
        System.out.println("\n=== LISTAGEM DE PROFESSORES ===");
 
        if (professor == null) {
            System.out.println("[AVISO] Nenhum professor cadastrado na turma.");
            return;
        }
 
        System.out.printf("Professor : %s\n", professor.getNome());
        System.out.printf("Matrícula : %s\n", professor.getMatricula());
 
        if (materia != null) {
            System.out.printf("Lecionando: %s (%dh)\n",
                    materia.getNomeMateria(), materia.getCargaHorariaTotal());
        } else {
            System.out.println("Lecionando: Nenhuma matéria associada.");
        }
        System.out.println("================================");
    }
    /**
     * Método para emitir relatório geral da turma com o relatório e a situação final de cada aluno
     */
    public void emitirRelatorioTurma() {
        if (materia == null || professor == null) {
            System.out.println("\n[ERRO] A turma ainda não possui Matéria ou Professor cadastrados.");
            System.out.println("Por favor, utilize as opções [1] e [2] do menu primeiro");
            return;
        }

        System.out.println("\n=================================");
        System.out.println("MATÉRIA: " + materia.getNomeMateria() + " (" + materia.getCargaHorariaTotal() + "h)");
        professor.gerarRelatorio();
        System.out.println("=================================");

        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado na turma.");
            return;
        }

        for (int i = 0; i < listaAlunos.size(); i++) {
            Aluno aluno = listaAlunos.get(i);
            
            System.out.println();
            aluno.gerarRelatorio();
            System.out.println("Situação final: " + aluno.calcularSituacao(materia.getCargaHorariaTotal()));
            System.out.println("---------------------------------");
        }
    }
    /**
     * Método para obter a matéria da turma
     * @return A matéria da turma, ou null se não houver
     */
    public Materia getMateria() {
        return materia;
    }
    /**
     * Métod para definir a matéria da turma
     * @param materia A matéria a ser associada
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    /**
     * Método para obter o professor da turma
     * @return O professor da turma, ou null se não houver
     */
    public Professor getProfessor() {
        return professor;
    }
    /**
     * Método para definir o professor da turma
     * @param professor O professor a ser associado
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    /**
     * Método para obter a lista de alunos matriculados
     * @return A lista de alunos da turma
     */
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}
