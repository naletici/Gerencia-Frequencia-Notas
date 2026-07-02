package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Aluno;
import main.NotaInvalidaException;
import main.Prova;
import main.TrabalhoPratico;

@DisplayName("Testes da classe Aluno")
class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	void preparar() {
		aluno = new Aluno();
		aluno.setNome("Maria Silva");
		aluno.setMatricula("2024001");
	}

	@Test
	@DisplayName("média parcial é 0 quando não há avaliações")
	void mediaSemAvaliacoes() {
		assertEquals(0.0, aluno.calcularMediaParcial(), 0.0001);
	}

	@Test
	@DisplayName("média parcial é a média das notas das avaliações")
	void mediaComAvaliacoes() {
		aluno.adicionarAvaliacao(new Prova("P1", 6.0));
		aluno.adicionarAvaliacao(new Prova("P2", 8.0));
		assertEquals(7.0, aluno.calcularMediaParcial(), 0.0001);
	}

	@Test
	@DisplayName("peso do trabalho prático reflete na média")
	void mediaComPeso() {
		aluno.adicionarAvaliacao(new TrabalhoPratico("Projeto", 8.0, 0.5));
		assertEquals(4.0, aluno.calcularMediaParcial(), 0.0001);
	}

	@Test
	@DisplayName("registrarFaltas ignora quantidades não positivas")
	void faltasNaoPositivas() {
		aluno.registrarFaltas(-3);
		aluno.registrarFaltas(0);
		assertEquals(0, aluno.getFaltas());
		aluno.registrarFaltas(5);
		assertEquals(5, aluno.getFaltas());
	}

	@Test
	@DisplayName("faltas acima de 25% reprovam por falta (mesmo com média alta)")
	void reprovaPorFalta() {
		aluno.adicionarAvaliacao(new Prova("P1", 10.0));
		aluno.registrarFaltas(21); // limite de 80h é 20
		assertEquals("Reprovado por Falta.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("faltas exatamente no limite não reprovam por falta")
	void faltasNoLimite() {
		aluno.adicionarAvaliacao(new Prova("P1", 10.0));
		aluno.registrarFaltas(20);
		assertEquals("Aprovado Direto.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("média >= 7 => Aprovado Direto")
	void aprovadoDireto() {
		aluno.adicionarAvaliacao(new Prova("P1", 7.0));
		assertEquals("Aprovado Direto.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("média < 5 => Reprovado Direto")
	void reprovadoDireto() {
		aluno.adicionarAvaliacao(new Prova("P1", 3.0));
		assertEquals("Reprovado Direto.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("média entre 5 e 7 sem nota final => Em Avaliação Final")
	void emAvaliacaoFinal() {
		aluno.adicionarAvaliacao(new Prova("P1", 6.0));
		assertEquals("Em Avalição Final.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("média de recuperação >= 5 => Aprovado na Final")
	void aprovadoNaFinal() {
		aluno.adicionarAvaliacao(new Prova("P1", 6.0));
		aluno.setNotaFinal(6.0); // (6 + 6) / 2 = 6.0
		assertEquals("Aprovado na Final.", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("média de recuperação < 5 => Reprovado na Final")
	void reprovadoNaFinal() {
		aluno.adicionarAvaliacao(new Prova("P1", 5.0));
		aluno.setNotaFinal(4.0); // (5 + 4) / 2 = 4.5
		assertEquals("Reprovado na Final", aluno.calcularSituacao(80));
	}

	@Test
	@DisplayName("setNotaFinal rejeita valores fora de [0, 10]")
	void notaFinalInvalida() {
		assertThrows(NotaInvalidaException.class, () -> aluno.setNotaFinal(11.0));
		assertThrows(NotaInvalidaException.class, () -> aluno.setNotaFinal(-1.0));
		assertDoesNotThrow(() -> aluno.setNotaFinal(0.0));
		assertDoesNotThrow(() -> aluno.setNotaFinal(10.0));
	}

	@Test
	@DisplayName("adicionarAvaliacao guarda a avaliação na lista")
	void adicionarAvaliacao() {
		aluno.adicionarAvaliacao(new Prova("P1", 5.0));
		assertEquals(1, aluno.getAvaliacoes().size());
	}

	@Test
	@DisplayName("gerarRelatorio imprime nome, matrícula e média parcial")
	void gerarRelatorio() {
		Aluno comCaptura = new Aluno();
		comCaptura.setNome("Maria Silva");
		comCaptura.setMatricula("2024001");
		comCaptura.adicionarAvaliacao(new Prova("P1", 8.0));

		PrintStream original = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));
		try {
			assertDoesNotThrow(comCaptura::gerarRelatorio);
		} finally {
			System.setOut(original);
		}

		String saida = buffer.toString();
		assertTrue(saida.contains("Maria Silva"), "deve conter o nome");
		assertTrue(saida.contains("2024001"), "deve conter a matrícula");
		assertTrue(saida.contains("Média Parcial"), "deve conter a média parcial");
	}
}
