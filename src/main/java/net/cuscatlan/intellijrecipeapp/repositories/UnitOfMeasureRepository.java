package net.cuscatlan.intellijrecipeapp.repositories;

import net.cuscatlan.intellijrecipeapp.models.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    public Optional<UnitOfMeasure> findByDescription(String description);

}
