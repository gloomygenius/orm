package org.gloomygenius.orm.inheritance.mapped_superclass;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Animal {
    private String name;
}