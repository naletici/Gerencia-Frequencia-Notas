package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.MembroAcademico;

@DisplayName("Testes da classe MembroAcademico")
class MembroAcademicoTest {
	static class MembroConcreto extends MembroAcademico {
		MembroConcreto() {
			super();
		}
		MembroConcreto(String nome, String matricula) {
			super(nome, matricula);
		}
	}

	@Test
	@DisplayName("construtor padrão deixa nome e matrícula nulos")
	void construtorPadrao() {
		MembroConcreto m = new MembroConcreto();
		assertNull(m.getNome());
		assertNull(m.getMatricula());
	}

	@Test
	@DisplayName("construtor com argumentos define nome e matrícula")
	void construtorComArgumentos() {
		MembroConcreto m = new MembroConcreto("Ana", "2024010");
		assertEquals("Ana", m.getNome());
		assertEquals("2024010", m.getMatricula());
	}

	@Test
	@DisplayName("setters atualizam nome e matrícula")
	void setters() {
		MembroConcreto m = new MembroConcreto();
		m.setNome("Bruno");
		m.setMatricula("2024011");
		assertEquals("Bruno", m.getNome());
		assertEquals("2024011", m.getMatricula());
	}
}
