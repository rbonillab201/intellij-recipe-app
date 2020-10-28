package net.cuscatlan.intellijrecipeapp.repositories;

import net.cuscatlan.intellijrecipeapp.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Optional<Category> findByDescription(String description);
}
