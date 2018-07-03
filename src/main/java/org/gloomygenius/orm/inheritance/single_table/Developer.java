package org.gloomygenius.orm.inheritance.single_table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Developer extends Employee {
    private String programmingLang;
}
