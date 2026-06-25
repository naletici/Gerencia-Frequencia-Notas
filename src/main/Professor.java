package src.main;

public class Professor extends MembroAcademico implements RelatorioGeravel {
    @Override
    public void gerarRelatorio() {
        System.out.println("Professor: " + getNome() + " (Matrícula: " + getMatricula() + ")");
    }
}
