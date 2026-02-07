package org.edu.espe.mspoliza.controllers;

import jakarta.validation.Valid;
import org.edu.espe.mspoliza.models.Poliza;
import org.edu.espe.mspoliza.services.PolizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/poliza")
public class PolizaController {
    @Autowired
    private PolizaService service;

    @GetMapping
    public ResponseEntity<List<Poliza>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verPorId(@PathVariable Long id) {
        Optional<Poliza> libroOptional = service.buscarPorId(id);

        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("El libro con ID " + id + " no existe");
    }


    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Poliza cliente) {
        Poliza autorGuardado = service.guardar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Poliza poliza) {
        Optional<Poliza> autorOptional = service.buscarPorId(id);
        if(autorOptional.isPresent()) {
            Poliza autorDB= autorOptional.get();


            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(autorDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Poliza> libroOptional = service.buscarPorId(id);

        if (libroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
