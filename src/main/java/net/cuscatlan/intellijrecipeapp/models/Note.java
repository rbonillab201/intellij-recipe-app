package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@Entity
public class Note extends BaseId {
    @Lob
    private String recipeNotes;
    @OneToOne
    private Recipe recipe;
}
