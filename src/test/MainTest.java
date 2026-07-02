package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Main;

@DisplayName("Testes da classe Main")
class MainTest {

	private final InputStream entradaOriginal = System.in;
	private final PrintStream saidaOriginal = System.out;
	private ByteArrayOutputStream buffer;

	@BeforeEach
	void preparar() {
		System.setIn(new ByteArrayInputStream("12\n".getBytes()));
		buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));
	}

	@AfterEach
	void restaurar() {
		System.setIn(entradaOriginal);
		System.setOut(saidaOriginal);
	}

	@Test
	@DisplayName("main exibe o menu e encerra ao escolher a opção Sair")
	void executaEEncerra() {
		assertDoesNotThrow(() -> Main.main(new String[]{}));

		String saida = buffer.toString();
		assertTrue(saida.contains("Gerenciador de Frequência e Notas"), "deve exibir o menu");
		assertTrue(saida.contains("Encerrado com sucesso!"), "deve encerrar pela opção Sair");
	}
}
