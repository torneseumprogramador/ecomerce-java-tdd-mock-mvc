package com.didox.ecommerce.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedidoProdutosTestes {

	@Test
	void validarPropriedades() {
		var pedidoProduto = new PedidoProduto();
		pedidoProduto.setIdPedido(1);
		pedidoProduto.setIdProduto(1);
		pedidoProduto.setQuantidade(2);
		pedidoProduto.setValor(33.33);

		assertEquals(1, pedidoProduto.getIdPedido());
		assertEquals(1, pedidoProduto.getIdProduto());
		assertEquals(2, pedidoProduto.getQuantidade());
		assertEquals(33.33, pedidoProduto.getValor());
	}

}
