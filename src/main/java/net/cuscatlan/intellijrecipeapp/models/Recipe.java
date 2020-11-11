package net.cuscatlan.intellijrecipeapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe extends BaseId {

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    private String directions;
    @Lob
    private Byte[] image;
    // TO DO
    @OneToOne(cascade = CascadeType.ALL)
    private Note notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "recipe_categories",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe addIngredient(Ingredient ingredients){
        if(ingredients != null){
            ingredients.setRecipe(this);
            this.ingredients.add(ingredients);
        }
        return this;
    }

    public void setNotes(Note notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }
}
