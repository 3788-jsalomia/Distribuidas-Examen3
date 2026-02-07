package com.example.cliente.services;

import com.example.cliente.models.Cliente;
import com.example.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    //@Transactional(readOnly = true)
    public List<Cliente> buscarTodos(){
        List<Cliente> autors = new ArrayList<>();
        repository.findAll().forEach(autors::add);
        return autors;
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

}
