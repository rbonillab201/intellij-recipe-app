package net.cuscatlan.intellijrecipeapp.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class UnitOfMessure extends BaseId{
    private String description;
}
