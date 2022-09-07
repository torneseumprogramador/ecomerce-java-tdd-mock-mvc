package com.didox.ecommerce.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutosDaoTests {

	@Autowired
	private IProdutosDao produtosDao;

	@BeforeEach
    public void limpaBase() {
        produtosDao.deleteAll();
    }

	@Test
	void validarFindDoDaoDeCliente() {
		assertEquals(0, produtosDao.count());
	}
}
