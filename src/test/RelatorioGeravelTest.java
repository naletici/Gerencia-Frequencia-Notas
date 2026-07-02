package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Aluno;
import main.Professor;
import main.RelatorioGeravel;

@DisplayName("Testes da interface RelatorioGeravel")
class RelatorioGeravelTest {

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
	@DisplayName("Professor pode ser tratado como RelatorioGeravel")
	void professorComoRelatorio() {
		Professor prof = new Professor();
		prof.setNome("Dr. Carlos");
		prof.setMatricula("PROF-01");

		RelatorioGeravel r = prof;
		assertDoesNotThrow(r::gerarRelatorio);
		assertTrue(buffer.toString().contains("Dr. Carlos"));
	}

	@Test
	@DisplayName("Aluno pode ser tratado como RelatorioGeravel")
	void alunoComoRelatorio() {
		Aluno aluno = new Aluno();
		aluno.setNome("Maria Silva");
		aluno.setMatricula("2024001");

		RelatorioGeravel r = aluno;
		assertDoesNotThrow(r::gerarRelatorio);
		assertTrue(buffer.toString().contains("Maria Silva"));
	}
}
