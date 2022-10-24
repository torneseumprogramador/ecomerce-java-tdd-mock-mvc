package com.didox.ecommerce.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.didox.ecommerce.models.PedidoProduto;

@Repository
public interface IPedidosProdutosDao extends CrudRepository<PedidoProduto, Integer> {
}
