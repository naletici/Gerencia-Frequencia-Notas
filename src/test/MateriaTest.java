package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Materia;

@DisplayName("Testes da classe Materia")
class MateriaTest {

	private Materia materia;

	@BeforeEach
	void preparar() {
		materia = new Materia();
	}

	@Test
	@DisplayName("nome da matéria é armazenado e recuperado")
	void nomeMateria() {
		materia.setNomeMateria("Programação Orientada a Objetos");
		assertEquals("Programação Orientada a Objetos", materia.getNomeMateria());
	}

	@Test
	@DisplayName("carga horária é armazenada e recuperada")
	void cargaHoraria() {
		materia.setCargaHorariaTotal(80);
		assertEquals(80, materia.getCargaHorariaTotal());
	}
}
