package main;
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
        while (opcao != 12);
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
        System.out.println("--- Consultas ---");
        System.out.println("[6]. Gerar Relatório.");
        System.out.println("[7]. Listar Matérias.");
        System.out.println("[8]. Listar Professores.");
        System.out.println("--- Remoções ---");
        System.out.println("[9]. Remover Matéria.");
        System.out.println("[10]. Remover Professor.");
        System.out.println("[11]. Remover Aluno.");
        System.out.println("----------------------------------------");
        System.out.println("[12]. Sair.");
        System.out.println("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao){
        switch(opcao) {
            case 1:
                cadastrarMateria();
                break;
            case 2:
                cadastrarProfessor();
                break;
            case 3:
                cadastrarAluno();
                break;
            case 4:
                lancarAvaliacao();
                break;
            case 5:
                registrarFaltasAluno();
                break;
            case 6:
                emitirRelatorio();
                break;
            case 7:
                listarMaterias();
                break;
            case 8:
                listarProfessores();
                break;
            case 9:
                removerMateria();
                break;
            case 10:
                removerProfessor();
                break;
            case 11:
                removerAluno();
                break;
            case 12:
                System.out.println("\nEncerrando Gerenciador...");
                System.out.println("\nEncerrado com sucesso!");
                break;
            default:
                System.out.println("\nComando Inválido! Tente novamente.");
        }
    }

    private static void cadastrarMateria(){ 
        System.out.println("\n--- Cadastro de Matéria ---");
        System.out.print("Nome da Matéria: ");
        String nome = scanner.nextLine();

        try {
            System.out.print("Carga Horária Total (ex: 80): ");
            int carga = Integer.parseInt(scanner.nextLine());

            Materia m = new Materia();
            m.setNomeMateria(nome);
            m.setCargaHorariaTotal(carga);

            turmaAtiva.setMateria(m);
            System.out.println("[SUCESSO] Matéria cadastrada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("[ERRO] A carga horária deve ser um número inteiro.");
        }
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastro de Professor ---");
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do Professor: ");
        String matricula = scanner.nextLine();
 
        Professor p = new Professor();
        p.setNome(nome);
        p.setMatricula(matricula);
 
        turmaAtiva.setProfessor(p);
        System.out.println("[SUCESSO] Professor vinculado à turma com sucesso!");

    }

    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(nome);
        novoAluno.setMatricula(matricula);

        turmaAtiva.matricularAluno(novoAluno);
        System.out.println("[SUCESSO] Aluno cadastrado na turma com sucesso!");
    }

    private static void lancarAvaliacao() {
        List<Aluno> listaAlunos = turmaAtiva.getListaAlunos();

        if(listaAlunos == null || listaAlunos.isEmpty()) {
            System.out.println("\n[AVISO] Nenhum aluno matriculado na turma.");
            return;
        }

        listarAlunos(listaAlunos);
        System.out.println("Selecione o índice do aluno para lançar a nota.");

        try {
            int indice = Integer.parseInt(scanner.nextLine());

            if (indice < 0 || indice >= listaAlunos.size()) {
                System.out.println("[ERRO] Índice de aluno inválido.");
                return;
            }

            Aluno alunoSelecionado = listaAlunos.get(indice);

            System.out.println("[1]. Prova Normal");
            System.out.println("[2]. Trabalho Prático");
            System.out.println("[3]. Avaliação Final");
            System.out.print("Escolha o tipo de avaliação: ");
            int tipo = Integer.parseInt(scanner.nextLine());
            
            if (tipo == 1) {
                System.out.print("Nome da Prova: ");
                String nomeProva = scanner.nextLine();
                System.out.print("Nota Obtida: ");
                double notaProva = Double.parseDouble(scanner.nextLine());

                Prova prova = new Prova(nomeProva, notaProva);
                alunoSelecionado.adicionarAvaliacao(prova);
                System.out.println("[SUCESSO] Prova registrada com sucesso.");

            } else if (tipo == 2) {
                System.out.print("Nome do Trabalho: ");
                String nomeTrab = scanner.nextLine();
                System.out.print("Nota Obtida: ");
                double notaTrab = Double.parseDouble(scanner.nextLine());
                System.out.print("Peso do Trabalho: ");
                double pesoTrab = Double.parseDouble(scanner.nextLine());
 
                TrabalhoPratico trabalho = new TrabalhoPratico(nomeTrab, notaTrab, pesoTrab);
                alunoSelecionado.adicionarAvaliacao(trabalho);
                System.out.println("[SUCESSO] Trabalho registrado com sucesso.");

            } else if (tipo == 3) {
                System.out.print("Nota da Avaliação Final (0 a 10): ");
                double notaFinal = Double.parseDouble(scanner.nextLine());
                alunoSelecionado.setNotaFinal(notaFinal);
                System.out.println("[SUCESSO] Nota final (Recuperação) registrada com sucesso.");
 
            } else {
                System.out.println("[ERRO] Tipo de avaliação inválido.");
            }
        } catch (NotaInvalidaException e) {
            System.out.println("\n[ERRO DE VALIDAÇÃO] Falha ao registrar nota: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\n[ERRO] Por favor, digite um valor numérico válido.");
        }

    }

    private static void registrarFaltasAluno() {
        List<Aluno> listaAlunos = turmaAtiva.getListaAlunos();
 
        if (listaAlunos == null || listaAlunos.isEmpty()) {
            System.out.println("\n[AVISO] Nenhum aluno matriculado na turma.");
            return;
        }

        listarAlunos(listaAlunos);
        System.out.print("Selecione o índice do aluno: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine());
 
            if (indice < 0 || indice >= listaAlunos.size()) {
                System.out.println("[ERRO] Índice inválido.");
                return;
            }
 
            System.out.print("Digite a quantidade de faltas a adicionar: ");
            int faltas = Integer.parseInt(scanner.nextLine());
 
            Aluno alunoSelecionado = listaAlunos.get(indice);
            alunoSelecionado.registrarFaltas(faltas);
 
            System.out.println("[SUCESSO] Faltas computadas. Total atual do aluno: " + alunoSelecionado.getFaltas());
        } catch (NumberFormatException e) {
            System.out.println("\n[ERRO] Por favor, digite um valor numérico inteiro.");
        }
    }

    private static void emitirRelatorio() {
        System.out.println("\n --- Emitindo Relatório Geral ---");
        turmaAtiva.emitirRelatorioTurma();
    }

    private static void listarMaterias() {
        turmaAtiva.listarMaterias();
    }
 
    private static void listarProfessores() {
        turmaAtiva.listarProfessores();
    }


    private static void removerMateria() {
        System.out.println("\n--- Remover Matéria ---");
 
        if (turmaAtiva.getMateria() == null) {
            System.out.println("[AVISO] Não há nenhuma matéria cadastrada para remover.");
            return;
        }
 
        System.out.println("Matéria atual: " + turmaAtiva.getMateria().getNomeMateria());
        System.out.print("Confirma a remoção? (S/N): ");
        String confirmacao = scanner.nextLine();
 
        if (confirmacao.equalsIgnoreCase("S")) {
            turmaAtiva.removerMateria();
            System.out.println("[SUCESSO] Matéria removida com sucesso!");
        } else {
            System.out.println("[CANCELADO] Operação cancelada.");
        }

    }

    private static void removerProfessor() {
        System.out.println("\n--- Remover Professor ---");
 
        if (turmaAtiva.getProfessor() == null) {
            System.out.println("[AVISO] Não há nenhum professor cadastrado para remover.");
            return;
        }
 
        System.out.println("Professor atual: " + turmaAtiva.getProfessor().getNome()
                + " (Matrícula: " + turmaAtiva.getProfessor().getMatricula() + ")");
        System.out.print("Confirma a remoção? (S/N): ");
        String confirmacao = scanner.nextLine();
 
        if (confirmacao.equalsIgnoreCase("S")) {
            turmaAtiva.removerProfessor();
            System.out.println("[SUCESSO] Professor removido com sucesso!");
        } else {
            System.out.println("[CANCELADO] Operação cancelada.");
        }

    }

    private static void removerAluno() {
        System.out.println("\n--- Remover Aluno ---");
        List<Aluno> listaAlunos = turmaAtiva.getListaAlunos();
 
        if (listaAlunos == null || listaAlunos.isEmpty()) {
            System.out.println("[AVISO] Nenhum aluno matriculado na turma.");
            return;
        }
 
        listarAlunos(listaAlunos);
        System.out.print("Selecione o índice do aluno a remover: ");
 
        try {
            int indice = Integer.parseInt(scanner.nextLine());
 
            if (indice < 0 || indice >= listaAlunos.size()) {
                System.out.println("[ERRO] Índice inválido.");
                return;
            }
 
            Aluno aluno = listaAlunos.get(indice);
            System.out.printf("Confirma a remoção de %s (Matrícula: %s)? (S/N): ",
                    aluno.getNome(), aluno.getMatricula());
            String confirmacao = scanner.nextLine();
 
            if (confirmacao.equalsIgnoreCase("S")) {
                turmaAtiva.removerAluno(indice);
                System.out.println("[SUCESSO] Aluno removido com sucesso!");
            } else {
                System.out.println("[CANCELADO] Operação cancelada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n[ERRO] Por favor, digite um valor numérico inteiro.");
        }
    }

    private static void listarAlunos(List<Aluno> alunos) {
        System.out.println("\n--- Alunos Matriculados ---");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            System.out.printf("[%d] Matrícula: %s | Nome: %s\n", i, a.getMatricula(), a.getNome());
        }
    }
}
