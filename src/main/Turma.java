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

    public void removerProfessor() {
        this.professor = null;
    }

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
