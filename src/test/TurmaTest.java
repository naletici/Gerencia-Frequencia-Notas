package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Aluno;
import main.Materia;
import main.Professor;
import main.Prova;
import main.Turma;

@DisplayName("Testes da classe Turma")
class TurmaTest {

	private Turma turma;
	private Aluno aluno;
	private Materia materia;
	private Professor professor;

	@BeforeEach
	void preparar() {
		turma = new Turma();

		aluno = new Aluno();
		aluno.setNome("Maria Silva");
		aluno.setMatricula("2024001");

		materia = new Materia();
		materia.setNomeMateria("Programação Orientada a Objetos");
		materia.setCargaHorariaTotal(80);

		professor = new Professor();
		professor.setNome("Dr. Carlos");
		professor.setMatricula("PROF-01");
	}

	@Test
	@DisplayName("matricular aluno aumenta a lista; aluno nulo é ignorado")
	void matricularAluno() {
		turma.matricularAluno(aluno);
		assertEquals(1, turma.getListaAlunos().size());

		turma.matricularAluno(null);
		assertEquals(1, turma.getListaAlunos().size());
	}

	@Test
	@DisplayName("remover aluno por índice válido retorna true e por inválido retorna false")
	void removerAluno() {
		Aluno outro = new Aluno();
		outro.setNome("João");
		outro.setMatricula("2024002");

		turma.matricularAluno(aluno);
		turma.matricularAluno(outro);
		assertEquals(2, turma.getListaAlunos().size());

		assertTrue(turma.removerAluno(0));
		assertEquals(1, turma.getListaAlunos().size());

		assertFalse(turma.removerAluno(99));
		assertEquals(1, turma.getListaAlunos().size());
	}

	@Test
	@DisplayName("cadastrar e remover matéria")
	void materia() {
		turma.setMateria(materia);
		assertNotNull(turma.getMateria());
		assertEquals("Programação Orientada a Objetos", turma.getMateria().getNomeMateria());

		turma.removerMateria();
		assertNull(turma.getMateria());
	}

	@Test
	@DisplayName("cadastrar e remover professor")
	void professor() {
		turma.setProfessor(professor);
		assertNotNull(turma.getProfessor());
		assertEquals("Dr. Carlos", turma.getProfessor().getNome());

		turma.removerProfessor();
		assertNull(turma.getProfessor());
	}

	@Nested
	@DisplayName("Relatórios e listagens (saída no console)")
	class Relatorios {

		private final PrintStream saidaOriginal = System.out;
		private ByteArrayOutputStream buffer;

		@BeforeEach
		void capturarSaida() {
			buffer = new ByteArrayOutputStream();
			System.setOut(new PrintStream(buffer));
		}

		@AfterEach
		void restaurarSaida() {
			System.setOut(saidaOriginal);
		}

		@Test
		@DisplayName("listarMaterias mostra matéria, limite de faltas e alunos")
		void listarMaterias() {
			turma.setMateria(materia);
			turma.matricularAluno(aluno);

			turma.listarMaterias();

			String saida = buffer.toString();
			assertTrue(saida.contains("Programação Orientada a Objetos"));
			assertTrue(saida.contains("Limite de Faltas"));
			assertTrue(saida.contains("Maria Silva"));
		}

		@Test
		@DisplayName("listarProfessores mostra professor e matéria lecionada")
		void listarProfessores() {
			turma.setProfessor(professor);
			turma.setMateria(materia);

			turma.listarProfessores();

			String saida = buffer.toString();
			assertTrue(saida.contains("Dr. Carlos"));
			assertTrue(saida.contains("PROF-01"));
			assertTrue(saida.contains("Programação Orientada a Objetos"));
		}

		@Test
		@DisplayName("emitirRelatorioTurma exibe matéria, professor e situação final")
		void emitirRelatorioCompleto() {
			turma.setMateria(materia);
			turma.setProfessor(professor);
			aluno.adicionarAvaliacao(new Prova("P1", 9.0));
			turma.matricularAluno(aluno);

			turma.emitirRelatorioTurma();

			String saida = buffer.toString();
			assertTrue(saida.contains("Programação Orientada a Objetos"));
			assertTrue(saida.contains("Dr. Carlos"));
			assertTrue(saida.contains("Situação final"));
			assertTrue(saida.contains("Aprovado Direto."));
		}

		@Test
		@DisplayName("emitirRelatorioTurma sem matéria/professor exibe aviso de erro")
		void emitirRelatorioSemPreRequisitos() {
			turma.emitirRelatorioTurma();
			assertTrue(buffer.toString().contains("[ERRO]"));
		}
	}
}
