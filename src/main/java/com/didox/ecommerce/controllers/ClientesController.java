package com.didox.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.didox.ecommerce.daos.IClientesDao;
import com.didox.ecommerce.models.Cliente;

@RestController
public class ClientesController {

    @Autowired
    private IClientesDao repo;

    @GetMapping("/clientes")
    public Iterable<Cliente> index(){
        return repo.findAll();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        repo.save(cliente);
        return ResponseEntity.status(201).body(cliente);
    }
}
