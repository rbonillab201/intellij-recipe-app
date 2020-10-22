package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class UnitOfMeasure extends BaseId{
    private String description;
}
