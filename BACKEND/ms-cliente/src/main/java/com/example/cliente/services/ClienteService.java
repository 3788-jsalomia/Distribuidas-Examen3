package com.example.cliente.services;

import com.example.cliente.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> buscarTodos();
    Optional<Cliente> buscarPorId(Long id);
    Cliente guardar(Cliente autor);
    void eliminarPorId(Long id);
}
