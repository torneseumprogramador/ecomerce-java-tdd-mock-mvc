package com.didox.ecommerce.controllersRest;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.didox.ecommerce.daos.IClientesDao;
import com.didox.ecommerce.libs.HttpTestClient;
import com.didox.ecommerce.models.Cliente;
*/

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientesControllerTests {
	/*
	@Autowired
	private IClientesDao repo;

	@BeforeEach
	private void preparaDatabase(){
		repo.deleteAll();
	}

	@Test
	void rotaClientesGET() throws URISyntaxException, IOException, InterruptedException {
        var code = HttpTestClient.get("/clientes");
		assertEquals(200, code);
	}

	@Test
	void rotaClientesPOST() throws URISyntaxException, IOException, InterruptedException {
		var cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setEmail("danilo@teste.com");

        var code = HttpTestClient.post("/clientes", cliente);
		assertEquals(201, code);
	}

	@Test
	void rotaClientesPUT() throws URISyntaxException, IOException, InterruptedException {
		var cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setEmail("danilo@teste.com");
		repo.save(cliente);

		cliente.setNome("Danilo Santos");

        var code = HttpTestClient.put("/clientes/" + cliente.getId(), cliente);
		assertEquals(200, code);
	}

	@Test
	void rotaClientesDELETE() throws URISyntaxException, IOException, InterruptedException {
		var cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setEmail("danilo@teste.com");
		repo.save(cliente);

        var code = HttpTestClient.delete("/clientes/" + cliente.getId());
		assertEquals(204, code);
	}
	*/
}
