package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Avaliacao;
import main.NotaInvalidaException;

@DisplayName("Testes da classe Avaliacao")
class AvaliacaoTest {
	static class AvaliacaoConcreta extends Avaliacao {
		AvaliacaoConcreta(String nome, double nota) {
			super(nome, nota);
		}
		@Override
		public double calcularNotaTotal() {
			return getNotaObtida();
		}
	}

	@Test
	@DisplayName("construtor armazena nome e nota válidos")
	void construtorValido() {
		AvaliacaoConcreta a = new AvaliacaoConcreta("P1", 7.5);
		assertEquals("P1", a.getNomeAvaliacao());
		assertEquals(7.5, a.getNotaObtida(), 0.0001);
	}

	@Test
	@DisplayName("construtor aceita as fronteiras 0.0 e 10.0")
	void fronteirasValidas() {
		assertDoesNotThrow(() -> new AvaliacaoConcreta("Min", 0.0));
		assertDoesNotThrow(() -> new AvaliacaoConcreta("Max", 10.0));
	}

	@Test
	@DisplayName("construtor rejeita nota acima de 10")
	void notaAcimaDeDez() {
		assertThrows(NotaInvalidaException.class, () -> new AvaliacaoConcreta("P1", 10.5));
	}

	@Test
	@DisplayName("construtor rejeita nota abaixo de 0")
	void notaAbaixoDeZero() {
		assertThrows(NotaInvalidaException.class, () -> new AvaliacaoConcreta("P1", -1.0));
	}

	@Test
	@DisplayName("setNotaObtida valida o intervalo")
	void setterValida() {
		AvaliacaoConcreta a = new AvaliacaoConcreta("P1", 5.0);
		assertThrows(NotaInvalidaException.class, () -> a.setNotaObtida(11.0));
		assertDoesNotThrow(() -> a.setNotaObtida(9.0));
		assertEquals(9.0, a.getNotaObtida(), 0.0001);
	}

	@Test
	@DisplayName("setNomeAvaliacao atualiza o nome")
	void setNome() {
		AvaliacaoConcreta a = new AvaliacaoConcreta("P1", 5.0);
		a.setNomeAvaliacao("Prova Final");
		assertEquals("Prova Final", a.getNomeAvaliacao());
	}
}
