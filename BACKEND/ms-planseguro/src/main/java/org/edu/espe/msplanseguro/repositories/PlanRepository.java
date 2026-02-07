package org.edu.espe.msplanseguro.repositories;

import jakarta.transaction.Transactional;
import org.edu.espe.msplanseguro.models.Plan;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface PlanRepository extends CrudRepository<Plan,Long> {
}
