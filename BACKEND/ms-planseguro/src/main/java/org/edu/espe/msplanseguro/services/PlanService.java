package org.edu.espe.msplanseguro.services;

import org.edu.espe.msplanseguro.models.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    List<Plan> buscarTodos();
    Optional<Plan> buscarPorId(Long id);
    Plan guardar(Plan autor);
    void eliminarPorId(Long id);
}
