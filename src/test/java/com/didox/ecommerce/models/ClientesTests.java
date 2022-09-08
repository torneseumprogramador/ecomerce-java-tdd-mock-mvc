package com.didox.ecommerce.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientesTests {

	@Test
	void validarPropriedades() {

		var cliente = new Cliente();
		cliente.setNome("Kathleen");
		cliente.setEmail("kathleen@teste.com");
		cliente.setSenha("123456");
		cliente.setEndereco("Rua teste");
		cliente.setNumero("ac66");
		cliente.setCep("00000-000");
		cliente.setCidade("Uma cidade");
		cliente.setBairro("Um Bairro");
		cliente.setEstado("SP");
		cliente.setComplemento("Casa 1");

		assertEquals("Kathleen", cliente.getNome());
		assertEquals("kathleen@teste.com", cliente.getEmail());
		assertEquals("123456", cliente.getSenha());
		assertEquals("Rua teste", cliente.getEndereco());
		assertEquals("AC66", cliente.getNumero());
		assertEquals("00000-000", cliente.getCep());
		assertEquals("Uma cidade", cliente.getCidade());
		assertEquals("Um Bairro", cliente.getBairro());
		assertEquals("SP", cliente.getEstado());
		assertEquals("Casa 1", cliente.getComplemento());

	}

	@Test
	void numeroNullNaoPodeDarErro() {
		var cliente = new Cliente();
		assertEquals(null, cliente.getNumero());
	}

}
