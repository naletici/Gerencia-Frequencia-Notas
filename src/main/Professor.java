package src.main;
/**
 * Classe que representa um professor com a capacidade de gerar seu próprio relatório
 * Professor
 */
public class Professor extends MembroAcademico implements RelatorioGeravel {
    /**
     * Método para gerar o relatório do professor
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("Professor: " + getNome() + " (Matrícula: " + getMatricula() + ")");
    }
}
