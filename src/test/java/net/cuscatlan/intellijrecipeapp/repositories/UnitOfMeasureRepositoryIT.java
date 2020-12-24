package net.cuscatlan.intellijrecipeapp.repositories;

import net.cuscatlan.intellijrecipeapp.models.BaseId;
import net.cuscatlan.intellijrecipeapp.models.Category;
import net.cuscatlan.intellijrecipeapp.models.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class UnitOfMeasureRepositoryIT extends BaseId {


    @Autowired
    UnitOfMeasureRepository uomRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> uomCup = uomRepository.findByDescription("Cup");
        assertEquals("Cup", uomCup.get().getDescription());
    }

    @Test
    void findByDescriptionPint() {
        Optional<UnitOfMeasure> uomCup = uomRepository.findByDescription("Pint");
        assertEquals("Pint", uomCup.get().getDescription());
    }

    @Test
    void findByDescriptionCatJap(){
        Optional<Category> category = categoryRepository.findByDescription("Japanese");
        assertEquals("Japanese", category.get().getDescription());
    }

}