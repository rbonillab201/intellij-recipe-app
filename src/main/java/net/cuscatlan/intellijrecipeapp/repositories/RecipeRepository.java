package net.cuscatlan.intellijrecipeapp.repositories;

import net.cuscatlan.intellijrecipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
