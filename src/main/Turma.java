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
}
