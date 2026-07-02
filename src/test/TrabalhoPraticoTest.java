package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.NotaInvalidaException;
import main.TrabalhoPratico;

@DisplayName("Testes da classe TrabalhoPratico")
class TrabalhoPraticoTest {

	@Test
	@DisplayName("nota total = nota obtida x peso")
	void notaTotalAplicaPeso() {
		TrabalhoPratico tp = new TrabalhoPratico("Projeto", 8.0, 0.5);
		assertEquals(4.0, tp.calcularNotaTotal(), 0.0001);
	}

	@Test
	@DisplayName("peso é armazenado e recuperado")
	void getPeso() {
		TrabalhoPratico tp = new TrabalhoPratico("Projeto", 8.0, 0.5);
		assertEquals(0.5, tp.getPeso(), 0.0001);
	}

	@Test
	@DisplayName("alterar o peso reflete na nota total")
	void setPeso() {
		TrabalhoPratico tp = new TrabalhoPratico("Projeto", 8.0, 0.5);
		tp.setPeso(1.0);
		assertEquals(8.0, tp.calcularNotaTotal(), 0.0001);
	}

	@Test
	@DisplayName("construtor rejeita nota fora de [0, 10]")
	void notaInvalida() {
		assertThrows(NotaInvalidaException.class, () -> new TrabalhoPratico("Projeto", -2.0, 0.5));
	}
}
