package com.didox.ecommerce.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.didox.ecommerce.models.Cliente;
import com.didox.ecommerce.models.Pedido;

@SpringBootTest
class RelacionamentoTests {

	@Autowired
	private IPedidosDao pedidosDao;

	@Autowired
	private IClientesDao clientesDao;

	@BeforeEach
    public void limpaBase() {
        pedidosDao.deleteAll();
        clientesDao.deleteAll();
    }

	@Test
	void salvarPedido() {
		var cliente = new Cliente();
		cliente.setEmail("teste@teste.com");
		clientesDao.save(cliente);

		var pedido = new Pedido();
		pedido.setCliente(cliente);
		pedidosDao.save(pedido);


		assertEquals(true, pedido.getId() > 0);
		assertEquals(true, pedido.getCliente().getId() > 0);
	}
}
