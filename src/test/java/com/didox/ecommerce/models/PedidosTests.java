package com.didox.ecommerce.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedidosTests {

	@Test
	void validarPropriedades() {
		var data = LocalDateTime.now();

		var pedido = new Pedido();
		pedido.setIdCliente(1);
		pedido.setValorTotal(33.33);
		pedido.setData(data);

		assertEquals(1, pedido.getIdCliente());
		assertEquals(33.33, pedido.getValorTotal());
		assertEquals(data, pedido.getData());
	}

}
