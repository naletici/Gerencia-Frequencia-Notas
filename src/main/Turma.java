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
