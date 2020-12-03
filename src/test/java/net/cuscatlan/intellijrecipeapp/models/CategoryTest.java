package net.cuscatlan.intellijrecipeapp.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest extends BaseId {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    public void getIdentity() {
        Long idValue = 4L;
        category.setId(idValue);
        Assertions.assertEquals(4L, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}