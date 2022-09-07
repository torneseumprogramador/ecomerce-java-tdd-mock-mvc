package com.didox.ecommerce.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.didox.ecommerce.models.Produto;

@Repository
public interface IProdutosDao extends CrudRepository<Produto, Integer> {
}
