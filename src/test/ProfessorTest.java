package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.MembroAcademico;
import main.Professor;
import main.RelatorioGeravel;

@DisplayName("Testes da classe Professor")
class ProfessorTest {

	private final PrintStream saidaOriginal = System.out;
	private ByteArrayOutputStream buffer;
	private Professor professor;

	@BeforeEach
	void preparar() {
		professor = new Professor();
		professor.setNome("Dr. Carlos");
		professor.setMatricula("PROF-01");
		buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));
	}

	@AfterEach
	void restaurar() {
		System.setOut(saidaOriginal);
	}

	@Test
	@DisplayName("herda nome e matrícula de MembroAcademico")
	void herdaDados() {
		assertEquals("Dr. Carlos", professor.getNome());
		assertEquals("PROF-01", professor.getMatricula());
	}

	@Test
	@DisplayName("gerarRelatorio imprime nome e matrícula")
	void gerarRelatorio() {
		professor.gerarRelatorio();
		String saida = buffer.toString();
		assertTrue(saida.contains("Dr. Carlos"), "deve conter o nome");
		assertTrue(saida.contains("PROF-01"), "deve conter a matrícula");
	}

	@Test
	@DisplayName("é um MembroAcademico e um RelatorioGeravel")
	void hierarquia() {
		assertTrue(professor instanceof MembroAcademico);
		assertTrue(professor instanceof RelatorioGeravel);
	}
}
