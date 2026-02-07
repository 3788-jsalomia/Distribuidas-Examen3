package com.example.cliente.repositories;

import com.example.cliente.models.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
