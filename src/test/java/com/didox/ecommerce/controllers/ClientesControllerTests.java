package com.didox.ecommerce.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientesControllerTests {

	@Test
	void rotaClientesGET() throws URISyntaxException, IOException, InterruptedException {

        HttpGet get = new HttpGet("http://localhost:8080/clientes");

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        get.addHeader("Content-Type", "application/json");

        var response = client.execute(get);
        
		// String responseAsString = EntityUtils.toString(response.getEntity());
        // System.out.println(responseAsString);

		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	void rotaClientesPOST() throws URISyntaxException, IOException, InterruptedException {

        HttpPost post = new HttpPost("http://localhost:8080/clientes");

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        post.addHeader("Content-Type", "application/json");

		String jsonFile = "{nome:\"Danilo\", email:\"danilo@teste.com\"}";
		HttpEntity entity = new StringEntity(jsonFile);
		post.setEntity(entity);

        var response = client.execute(post);
        
		assertEquals(201, response.getStatusLine().getStatusCode());
	}
}
