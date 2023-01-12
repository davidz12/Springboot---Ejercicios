package com.example.api.bazar.service;

import com.example.api.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    public Cliente findCliente(Long id);
    
    public List<Cliente> findAllClientes();
    
    public void saveCliente(Cliente cliente);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente cliente);
}
