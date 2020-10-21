package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;

import javax.persistence.*;
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
    private Set<Ingredient> ingredients;
    //private Set<Category> categories;



}
