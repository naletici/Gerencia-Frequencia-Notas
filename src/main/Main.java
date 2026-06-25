package src.main;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Turma turmaAtiva = new Turma();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] a) {
        
    }

    private static void exibirMenu() {
        System.out.println("================================================");
        System.out.println("        Gerenciador de Frequência e Notas       ");
        System.out.println("================================================");
        System.out.println("[1]. Cadastrar Matéria.");
        System.out.println("[2]. Cadastrar Professor.");
        System.out.println("[3]. Cadastrar Aluno.");
        System.out.println("[4]. Lançar Notas.");
        System.out.println("[5]. Lançar Faltas.");
        System.out.println("[6]. Gerar Relatório.");
        System.out.println("[7]. Sair.");
        System.out.println("Escolha uma opção.");
    }

    private static void escolherOpcao(int opcao){
        switch(opcao) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.out.println("\nEncerrando Gerenciador...");
                System.out.println("\nEncerrado com sucesso!");
                break;
            default:
                System.out.println("\nComando Inválido! Tente novamente.");
        }
    }
}
