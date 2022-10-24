package com.didox.ecommerce.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.didox.ecommerce.models.Pedido;

@Repository
public interface IPedidosDao extends CrudRepository<Pedido, Integer> {
}
