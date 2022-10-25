package com.didox.ecommerce.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

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

	@Autowired
	private EntityManager entityManager;

	@BeforeEach
    public void limpaBase() {
        pedidosDao.deleteAll();
        clientesDao.deleteAll();
    }

	@Test
	void pedidoRelacionamento() {
		var cliente = new Cliente();
		cliente.setEmail("teste@teste.com");
		clientesDao.save(cliente);


		Cliente clienteReference = entityManager.getReference(Cliente.class, cliente.getId());

		var pedido = new Pedido();
		pedido.setCliente(clienteReference);
		pedidosDao.save(pedido);

		assertEquals(true, pedido.getId() > 0);
		assertEquals(true, pedido.getCliente().getId() > 0);

		// var clienteDb = clientesDao.findById(cliente.getId()).get();
		// assertEquals(1, clienteDb.getPedidos().size());
	}
}
