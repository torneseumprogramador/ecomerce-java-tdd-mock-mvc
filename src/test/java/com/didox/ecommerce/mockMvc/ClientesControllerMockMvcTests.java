package com.didox.ecommerce.mockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.didox.ecommerce.daos.IClientesDao;
import com.didox.ecommerce.models.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientesControllerMockMvcTests {
	@Autowired
	private IClientesDao clientesDao;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void clientesGET() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/clientes"))
			   .andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void clientesSemRotaGET() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/clientess"))
			   .andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void clientesPOST() throws Exception {
		Cliente cliente = clienteFake();
		String json = new ObjectMapper().writeValueAsString(cliente);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	@Test
	void clientesPUT() throws Exception {
		clientesDao.deleteAll();

		Cliente cliente = clienteFake();
		clientesDao.save(cliente);

		cliente.setNome("teste");
		String json = new ObjectMapper().writeValueAsString(cliente);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/clientes/" + cliente.getId())
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void clientesPUTBody() throws Exception {
		clientesDao.deleteAll();

		Cliente cliente = clienteFake();
		clientesDao.save(cliente);

		cliente.setNome("teste");
		String json = new ObjectMapper().writeValueAsString(cliente);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/clientes/" + cliente.getId())
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();

		String jsonString = result.getResponse().getContentAsString();
		Cliente clienteRest = new Gson().fromJson(jsonString, Cliente.class);
		assertEquals("teste", clienteRest.getNome());
	}

	private Cliente clienteFake() {
		var cliente = new Cliente();
		cliente.setEmail("teste@test.com");
		return cliente;
	}

	// factoryBuilder token url para JWT
	private MockHttpServletRequestBuilder factoryBuilder(String url, String token) {
		return MockMvcRequestBuilders.post(url)
				.header("Authorization", token.trim());
	}
}
