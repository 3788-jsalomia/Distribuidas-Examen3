package org.edu.espe.msplanseguro.services;

import org.edu.espe.msplanseguro.models.Plan;
import org.edu.espe.msplanseguro.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository repository;

    @Override
    //@Transactional(readOnly = true)
    public List<Plan> buscarTodos(){
        List<Plan> autors = new ArrayList<>();
        repository.findAll().forEach(autors::add);
        return autors;
    }

    @Override
    public Optional<Plan> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Plan guardar(Plan cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

}
