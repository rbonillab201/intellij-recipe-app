package net.cuscatlan.intellijrecipeapp.controllers;

import net.cuscatlan.intellijrecipeapp.models.BaseId;
import net.cuscatlan.intellijrecipeapp.models.Ingredient;
import net.cuscatlan.intellijrecipeapp.models.Note;
import net.cuscatlan.intellijrecipeapp.models.Recipe;
import net.cuscatlan.intellijrecipeapp.repositories.RecipeRepository;
import net.cuscatlan.intellijrecipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IndexControllerTest extends BaseId {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;


    Set<Recipe> arrayRecipe = new HashSet<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
        Set<Recipe> recetas = new HashSet<>();
        System.out.println("show: " + recipeService.toString());

        Recipe recipes = new Recipe();
        recipes.setUrl("www");
        recipes.setSource("Recetas varias");
        recipes.setDirections("Direccion");
        recipes.setCookTime(10);
        recipes.setPrepTime(20);
        recipes.setDescription("Descripción");
        recipes.setServing(1);
        recipes.setId(1L);


        Note notes = new Note();
        notes.setRecipeNotes("Notsa de la receta");
        notes.setRecipe(recipes);

        recipes.setNotes(notes);

        recetas.add(recipes);

        System.out.println(" --> " + recetas);

        //Given
     //   Set<Recipe> arrayRecipe = new HashSet<>();
        System.out.println(" 0 " + arrayRecipe.size());
        arrayRecipe.add(new Recipe());
        System.out.println(" 1 " + arrayRecipe.size());

        Recipe receipt1 = new Recipe();
        Recipe receipt2 = new Recipe();

        receipt1.setId(5L);
        receipt1.setUrl("www");
        arrayRecipe.add(receipt1);
        System.out.println(" 2 " + arrayRecipe.size());
        receipt2.setId(6L);
        receipt2.setSource("source");
        arrayRecipe.add(receipt2);
        System.out.println(" 3 " + arrayRecipe.size());

    }

    @Test
    void myIndex() {

        when(recipeService.getRecipes()).thenReturn(arrayRecipe);



        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        System.out.println("Argument1: " + argumentCaptor.toString());


        // when
        String viewname = controller.myIndex(model);


        //then

        assertEquals("index", viewname);

        verify(recipeService, Mockito.times(1)).getRecipes();
        verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture()); // Mockito.anySet());
        System.out.println("Objetos: " + argumentCaptor.getValue().size());
        Set<Recipe> inController = argumentCaptor.getValue();
        assertEquals(3, inController.size());


    }
}