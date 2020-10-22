package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Category extends BaseId{
    private String categoryName;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
