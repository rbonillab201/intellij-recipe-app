package net.cuscatlan.intellijrecipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import net.cuscatlan.intellijrecipeapp.models.*;
import net.cuscatlan.intellijrecipeapp.repositories.CategoryRepository;
import net.cuscatlan.intellijrecipeapp.repositories.RecipeRepository;
import net.cuscatlan.intellijrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.awt.desktop.AppHiddenListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

    public final CategoryRepository categoryRepository;
    public final UnitOfMeasureRepository unitOfMeasureRepository;
    public final RecipeRepository recipeRepository;

    public LoadData(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getData());
        log.info("En el inicio de la aplicación, onApplicationEvent");
    }

    public List<Recipe> getData(){
        List<Recipe> recipes = new ArrayList<>();

        log.info("Iniciando la carga");

        Recipe recipeTacos = new Recipe();

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(teaspoonUomOptional.isEmpty()){
            throw new RuntimeException("Teaspoon does not exist");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(mexicanCategoryOptional.isEmpty()){
            throw new RuntimeException("Mexican does not exist");
        }

        recipeTacos.setDescription("Tacos Ricoss");
        recipeTacos.setCookTime(0);
        recipeTacos.setPrepTime(10);
        recipeTacos.setDirections("Solo cocine");
        recipeTacos.setUrl("www");
        recipeTacos.setSource("Tacos de Paco");

        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();

        recipeTacos.addIngredient(new Ingredient("Tortillas", new BigDecimal(4), teaspoonUom));

        Note notes = new Note();
        notes.setRecipeNotes("Notas");
        notes.setRecipe(recipeTacos);

        recipeTacos.setNotes(notes);

        recipes.add(recipeTacos);

        Recipe recipeCeviche = new Recipe();
        recipeCeviche.setDescription("Ceviches Ricos");
        recipeCeviche.setPrepTime(30);
        recipeCeviche.setCookTime(0);
        recipeCeviche.setUrl("www");
        recipeCeviche.setDirections("Se corta todo bien cortado");
        recipeCeviche.setSource("Recetas faciles");

        Optional<UnitOfMeasure> onzUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if(onzUomOptional.isEmpty()){
            throw new RuntimeException("Ounce does not exist");
        }
        UnitOfMeasure onzUom = onzUomOptional.get();
        System.out.println("Salida del get()");
        System.out.println(onzUom);

        recipeCeviche.addIngredient(new Ingredient("Lonja de pescado", new BigDecimal(32), onzUom));

        Note notesCeviche = new Note();
        notesCeviche.setRecipeNotes("Estas son las notas");
      //  No es necesario por el cambio en la clase recipes notesCeviche.setRecipe(recipeCeviche);

        recipeCeviche.setNotes(notesCeviche);

        recipes.add(recipeCeviche);

        log.info("finalizando la carga $$");

        return recipes;

    }

}
