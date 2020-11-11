package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data()
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category extends BaseId{
    private String description;
    @ToString.Exclude
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();
}
