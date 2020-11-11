package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note extends BaseId {
    @Lob
    private String recipeNotes;
    @ToString.Exclude
    @OneToOne
    private Recipe recipe;
}
