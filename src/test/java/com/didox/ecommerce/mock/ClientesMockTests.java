package com.didox.ecommerce.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.didox.ecommerce.daos.IClientesDao;
import com.didox.ecommerce.models.Cliente;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ClientesMockTests {

	@Captor
	ArgumentCaptor<Cliente> clienteReqCaptor;
	
	@Mock
	private IClientesDao clientesDao;

	@Test
	void validarFindDoDaoDeCliente() {
		// Mock método count
		when(clientesDao.count()).thenReturn((long) 0);

		assertEquals(0, clientesDao.count());
	}

	@Test
	void validarSeEmailCadastradoNaoExiste() {
		// Mock método emailExiste
		when(clientesDao.emailExiste("dd@teste.com")).thenReturn(false);

		var clienteNaoExiste = clientesDao.emailExiste("dd@teste.com");
		assertEquals(false, clienteNaoExiste);
	}

	@Test
	void findById() {
		// Mock método emailExiste
		when(clientesDao.findById(1)).thenReturn(clienteFakeOptional("email@mock.com"));

		var cliente = clientesDao.findById(1);
		assertEquals("email@mock.com", cliente.get().getEmail());
	}

	@Test
	void findAll() {
		// Mock método emailExiste
		when(clientesDao.findAll()).thenReturn(clientesFake("email@mock.com"));

		var clientes = clientesDao.findAll();
		assertEquals("email@mock.com", clientes.iterator().next().getEmail());
	}

	@Test
	void validarSeEmailCadastradoExiste() {
		var cliente = new Cliente();
		cliente.setEmail("teste@teste.com");
		clientesDao.save(cliente);

		// Mock método emailExiste
		when(clientesDao.emailExiste("teste@teste.com")).thenReturn(clienteFake("teste@teste.com").getEmail().equals("teste@teste.com"));
		
		var clienteExiste = clientesDao.emailExiste("teste@teste.com");
		assertEquals(true, clienteExiste);
	}

	private Cliente clienteFake(String email) {
		Cliente cli = new Cliente();
		cli.setEmail(email);
		return cli;
	}

	private Optional<Cliente> clienteFakeOptional(String email) {
		var cliente = clienteFake(email);
		Optional<Cliente> clienteOptional = Optional.of(cliente);
		return clienteOptional;
	}

	private Iterable<Cliente> clientesFake(String email) {
		var clientes = new ArrayList<Cliente>();
		clientes.add(clienteFake(email));
		return clientes;
	}
}
