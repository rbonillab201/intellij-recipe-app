package net.cuscatlan.intellijrecipeapp.services;

import net.cuscatlan.intellijrecipeapp.models.Recipe;
import net.cuscatlan.intellijrecipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        System.out.println("Service Impl");
        System.out.println(recipes);
        return recipes;
    }
}
