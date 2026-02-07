package org.edu.espe.msplanseguro.controllers;

import jakarta.validation.Valid;
import org.edu.espe.msplanseguro.models.Plan;
import org.edu.espe.msplanseguro.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plan")
public class PlanController {
    @Autowired
    private PlanService service;

    @GetMapping
    public ResponseEntity<List<Plan>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verPorId(@PathVariable Long id) {
        Optional<Plan> libroOptional = service.buscarPorId(id);

        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("El Plan con ID " + id + " no existe");
    }


    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Plan plan) {
        Plan autorGuardado = service.guardar(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Plan plan) {
        Optional<Plan> autorOptional = service.buscarPorId(id);
        if(autorOptional.isPresent()) {
            Plan autorDB= autorOptional.get();
            autorDB.setNombre(plan.getNombre());
            autorDB.setTipo(plan.getTipo());
            autorDB.setPrimaBase(plan.getPrimaBase());
            autorDB.setCoberturaMax(plan.getCoberturaMax());



            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(autorDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Plan> libroOptional = service.buscarPorId(id);

        if (libroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
