package net.cuscatlan.intellijrecipeapp.repositories;

import net.cuscatlan.intellijrecipeapp.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
