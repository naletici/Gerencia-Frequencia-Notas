package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.NotaInvalidaException;
import main.Prova;

@DisplayName("Testes da classe Prova")
class ProvaTest {

	@Test
	@DisplayName("nota total da prova é a própria nota obtida")
	void notaTotal() {
		Prova p = new Prova("P1", 8.0);
		assertEquals(8.0, p.calcularNotaTotal(), 0.0001);
	}

	@Test
	@DisplayName("construtor guarda o nome da prova")
	void nome() {
		Prova p = new Prova("Prova 1", 6.0);
		assertEquals("Prova 1", p.getNomeAvaliacao());
	}

	@Test
	@DisplayName("construtor rejeita nota fora de [0, 10]")
	void notaInvalida() {
		assertThrows(NotaInvalidaException.class, () -> new Prova("P1", 12.0));
	}
}
