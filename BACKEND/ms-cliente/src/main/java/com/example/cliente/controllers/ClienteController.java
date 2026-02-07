package com.example.cliente.controllers;

import com.example.cliente.models.Cliente;
import com.example.cliente.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController  {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verPorId(@PathVariable Long id) {
        Optional<Cliente> libroOptional = service.buscarPorId(id);

        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("El libro con ID " + id + " no existe");
    }


    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Cliente cliente) {
        Cliente autorGuardado = service.guardar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> autorOptional = service.buscarPorId(id);
        if(autorOptional.isPresent()) {
            Cliente autorDB= autorOptional.get();
            cliente.setNombre(cliente.getNombre());
            cliente.setIdentificacion(cliente.getIdentificacion());
            cliente.setEmail(cliente.getEmail());
            cliente.setTelefono(cliente.getTelefono());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(autorDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Cliente> libroOptional = service.buscarPorId(id);

        if (libroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
