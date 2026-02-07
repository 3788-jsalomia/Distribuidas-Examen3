package org.edu.espe.mspoliza.services;

import org.edu.espe.mspoliza.models.Poliza;
import org.edu.espe.mspoliza.repositories.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolizaServiceImpl implements PolizaService{
    @Autowired
    private PolizaRepository repository;

    @Override
    //@Transactional(readOnly = true)
    public List<Poliza> buscarTodos(){
        List<Poliza> autors = new ArrayList<>();
        repository.findAll().forEach(autors::add);
        return autors;
    }

    @Override
    public Optional<Poliza> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Poliza guardar(Poliza cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}
