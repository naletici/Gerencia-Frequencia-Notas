package src.main;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Turma turmaAtiva = new Turma();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] a) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("\n[ERROR] Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("[ERRO INESPERADO] " + e.getMessage());
            }
        }
        while (opcao != 10);
    }

    private static void exibirMenu() {
        System.out.println("\n================================================");
        System.out.println("        Gerenciador de Frequência e Notas       ");
        System.out.println("================================================");
        System.out.println("--- Cadastros ---");
        System.out.println("[1]. Cadastrar Matéria.");
        System.out.println("[2]. Cadastrar Professor.");
        System.out.println("[3]. Cadastrar Aluno.");
        System.out.println("--- Lançamentos ---");
        System.out.println("[4]. Lançar Notas.");
        System.out.println("[5]. Lançar Faltas.");
        System.out.println("--- Relatório ---");
        System.out.println("[6]. Gerar Relatório.");
        System.out.println("--- Remoções ---");
        System.out.println("[7]. Remover Matéria");
        System.out.println("[8]. Remover Professor");
        System.out.println("[9]. Remover Aluno");
        System.out.println("----------------------------------------");
        System.out.println("[10]. Sair.");
        System.out.println("Escolha uma opção: ");
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
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                System.out.println("\nEncerrando Gerenciador...");
                System.out.println("\nEncerrado com sucesso!");
                break;
            default:
                System.out.println("\nComando Inválido! Tente novamente.");
        }
    }
}
