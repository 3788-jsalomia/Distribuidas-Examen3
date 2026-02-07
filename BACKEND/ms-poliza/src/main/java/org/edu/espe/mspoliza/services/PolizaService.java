package org.edu.espe.mspoliza.services;

import org.edu.espe.mspoliza.models.Poliza;

import java.util.List;
import java.util.Optional;

public interface PolizaService {
    List<Poliza> buscarTodos();
    Optional<Poliza> buscarPorId(Long id);
    Poliza guardar(Poliza autor);
    void eliminarPorId(Long id);
}
