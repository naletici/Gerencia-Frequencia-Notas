package src.main;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends MembroAcademico implements RelatorioGeravel {
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private double notaFinal = -1.0;
    private int faltas = 0;

    public void adicionarAvaliacao(Avaliacao a) {
        this.avaliacoes.add(a);
    }

    public void registrarFaltas(int quantidade) {
        if (quantidade > 0) {
            this.faltas += quantidade;
        }
    }

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
        
        double somaFinal = media + notaFinal;
        if (somaFinal >= 5.0) {
            return "Aprovado na Final.";
        } else {
            return "Reprovado na Final";
        }
    }

}
