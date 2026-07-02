package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.NotaInvalidaException;

@DisplayName("Testes da classe NotaInvalidaException")
class NotaInvalidaExceptionTest {

	@Test
	@DisplayName("mensagem passada no construtor é preservada")
	void guardaMensagem() {
		NotaInvalidaException e = new NotaInvalidaException("Nota inválida");
		assertEquals("Nota inválida", e.getMessage());
	}

	@Test
	@DisplayName("é uma RuntimeException (não checada)")
	void ehRuntimeException() {
		NotaInvalidaException e = new NotaInvalidaException("qualquer");
		assertTrue(e instanceof RuntimeException);
	}
}
