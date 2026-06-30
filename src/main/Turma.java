package src.main;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Materia materia;
    private Professor professor;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public void matricularAluno(Aluno aluno) {
        if (aluno != null) {
            listaAlunos.add(aluno);
        }
    }

    public boolean removerAluno(int indice) {
        if (indice >= 0 && indice < listaAlunos.size()) {
            listaAlunos.remove(indice);
            return true;
        }
        return false;
    }

    public void removerMateria() {
        this.materia = null;
    }

    public void emitirRelatorioTurma() {
        if (materia == null || professor == null) {
            System.out.println("\n[ERRO] A turma ainda não possui Matéria ou Professor cadastrados.");
            System.out.println("Por favor, utilize as opções [1] e [2] do menu primeiro");
            return;
        }

        System.out.println("\\n=================================");
        System.out.println("MATÉRIA: " + materia.getNomeMateria() + " (" + materia.getCargaHorariaTotal() + "h)");
        professor.gerarRelatorio();
        System.out.println("\\n=================================");
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}
