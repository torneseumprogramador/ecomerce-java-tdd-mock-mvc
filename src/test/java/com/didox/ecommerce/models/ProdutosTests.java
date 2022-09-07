package com.didox.ecommerce.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutosTests {

	@Test
	void validarPropriedades() {

		var produto = new Produto();
		produto.setNome("Mouse colorido");
		produto.setDescricao("Um produto feito no teste");
		produto.setValor(5.80);
		produto.setQuantidade(100);

		assertEquals("Mouse colorido", produto.getNome());
		assertEquals("Um produto feito no teste", produto.getDescricao());
		assertEquals(5.80, produto.getValor());
		assertEquals(100, produto.getQuantidade());
	}

	@Test
	void geraCodigoAoSetarNome(){
		var produto = new Produto();
		produto.setNome("Bicicleta");
		assertEquals("BIC-9", produto.getCodigo());
	}

	@Test
	void geraCodigoAoSetarNome2(){
		var produto = new Produto();
		produto.setNome("Cachorro vermelho");
		assertEquals("CAC-17", produto.getCodigo());
	}

	@Test
	void geraCodigoAoSetarNome3(){
		var produto = new Produto();
		produto.setNome("Banana Nanica");
		assertEquals("BAN-13", produto.getCodigo());
	}

	@Test
	void casoDigiteCodigoDepoisAltereNomeOCodigoFicaOMesmo(){
		var produto = new Produto();
		produto.setCodigo("TTT-21");
		produto.setNome("Banana Nanica");
		assertEquals("TTT-21", produto.getCodigo());
	}
}
