package com.didox.ecommerce.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.didox.ecommerce.daos.IClientesDao;
import com.didox.ecommerce.daos.IPedidosDao;
import com.didox.ecommerce.models.Cliente;
import com.didox.ecommerce.models.Pedido;

@CrossOrigin("*")
@RestController
public class PedidosController {

    @Autowired
    private IPedidosDao repo;

    @Autowired
    private IClientesDao repoCliente;
    
	@Autowired
	private EntityManager entityManager;

    @GetMapping("/pedidos")
    public Iterable<Pedido> index(){
        return repo.findAll();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> pedidoCriar(){
        var cliente = new Cliente();
        cliente.setEmail("umcliente@teste.com");

        var pedido = new Pedido();
        pedido.setCliente(cliente);
        repo.save(pedido);

        return ResponseEntity.status(200).body(pedido);
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> pedidoCriarAlterar(@PathVariable int id){
        var pedido = repo.findById(id).get();

        var clienteDb = repoCliente.findById(3).get();
        Cliente clienteReference = entityManager.getReference(Cliente.class, clienteDb.getId());

        pedido.setCliente(clienteReference);
        repo.save(pedido);

        return ResponseEntity.status(200).body(pedido);
    }
}
