package com.example.api.bazar.controller;

import com.example.api.bazar.model.Cliente;
import com.example.api.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServ;

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id) {
        return clienteServ.findCliente(id);
    }

    @GetMapping("/clientes")
    public List<Cliente> findAllClientes() {
        return clienteServ.findAllClientes();
    }

    @PostMapping("/clientes/crear")
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id) {
        clienteServ.deleteCliente(id);
    }

    @PutMapping("/clientes/editar")
    public void editCliente(@RequestBody Cliente cliente) {
        clienteServ.editCliente(cliente);
    }
}
