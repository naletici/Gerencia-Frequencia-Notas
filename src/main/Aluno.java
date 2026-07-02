package main;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um aluno e concentra as regras de média, situação final e faltas
 * Aluno
 */
public class Aluno extends MembroAcademico implements RelatorioGeravel {
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private double notaFinal = -1.0;
    private int faltas = 0;
    /**
     * Método para adicionar uma avaliação à lista do aluno
     * @param a A avaliação a ser adicionada
     */
    public void adicionarAvaliacao(Avaliacao a) {
        this.avaliacoes.add(a);
    }
    /**
     * Método para registrar faltas do aluno (quantidades negativas são ignoradas)
     * @param quantidade A quantidade de faltas a ser adicionada
     */
    public void registrarFaltas(int quantidade) {
        if (quantidade > 0) {
            this.faltas += quantidade;
        }
    }
    /**
     * Método para calcular a média parcial do aluno
     * @return A média aritmética das notas das avaliações ou 0.0 se não houver avaliações
     */
    public double calcularMediaParcial() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        } 

        double soma = 0;
        for(int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao a = avaliacoes.get(i);
            soma += a.calcularNotaTotal();
        }

        return soma / avaliacoes.size();
    }
    /**
     * Método para calcular a situação final do aluno na matéria
     * @param cargaHorariaTotal A carga horária total da matéria, base para o limite de faltas
     * @return Uma frase que descreve a situação final do aluno
     */
    public String calcularSituacao(int cargaHorariaTotal) {
        double limiteFaltas = cargaHorariaTotal * 0.25;
        if (this.faltas > limiteFaltas) {
            return "Reprovado por Falta.";
        }
        double media = calcularMediaParcial();
        if (media < 5.0) {
            return "Reprovado Direto.";
        }
        if (media >= 7.0) {
            return "Aprovado Direto.";
        }
        if (notaFinal == -1.0) {
            return "Em Avalição Final.";
        }
        
        double somaFinal = (media + notaFinal) / 2.0;
        if (somaFinal >= 5.0) {
            return "Aprovado na Final.";
        } else {
            return "Reprovado na Final";
        }
    }
    /**
     * Método para gerar o relatório individual do aluno
     */
    @Override
    public void gerarRelatorio() {
        System.out.printf("Aluno(a): %s | Matrícula %s | Faltas: %d\n", getNome(), getMatricula(), faltas);
        System.out.println("  [Nota das Avaliações]:");
        if (avaliacoes.isEmpty()) {
            System.out.println("  - Nenhuma Avaliação registrada ainda.");
        } else {
            for (int i = 0; i < avaliacoes.size(); i++) {
                Avaliacao a = avaliacoes.get(i);
                System.out.printf(" %s: %.2f\n", a.getNomeAvaliacao(), a.calcularNotaTotal());
            }
        }

        System.out.printf("  [Média Parcial]: %.2f\n", calcularMediaParcial());
        if (notaFinal != -1.0) {
            System.out.printf("  [Nota da Final]: %.2f\n", notaFinal);
        }
    }
    /**
     * Método para obter a lista de avaliações do aluno
     * @return A lista de avaliações registradas
     */
    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    /**
     * Método para definir a nota da avaliação final do aluno
     * @param notaFinal A nota da final
     * @throws NotaInvalidaException se a nota final estiver fora do intervalo (0, 10)
     */
    public void setNotaFinal(double notaFinal) {
        if (notaFinal < 0.0 || notaFinal > 10.0) {
            throw new NotaInvalidaException("A nota final deve estar entre 0.0 e 10.0");
        }
        this.notaFinal = notaFinal;
    }
    /**
     * Método para obter o total de faltas do aluno
     * @return O número total de faltas
     */
    public int getFaltas() {
        return faltas;
    }

}
