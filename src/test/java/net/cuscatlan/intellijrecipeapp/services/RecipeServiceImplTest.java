package net.cuscatlan.intellijrecipeapp.services;

import net.cuscatlan.intellijrecipeapp.models.BaseId;
import net.cuscatlan.intellijrecipeapp.models.Recipe;
import net.cuscatlan.intellijrecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpInputMessage;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest extends BaseId {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void getRecipes() {
        Recipe recipe1 = new Recipe();
        recipe1.setUrl("www");
        Recipe recipe2 = new Recipe();
        recipe2.setUrl("http");
        HashSet recipeData = new HashSet();
        System.out.println(" *** HashSet " + recipeData);
        recipeData.add(recipe1);
        recipeData.add(recipe2);

        System.out.println("Data: " + recipeData);
        Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        System.out.println(" <> " + recipes);
        assertEquals(recipes.size(), 2);
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();

    }
}