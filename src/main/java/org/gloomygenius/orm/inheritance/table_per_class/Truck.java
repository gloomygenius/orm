package org.gloomygenius.orm.inheritance.table_per_class;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Truck extends Car {
    private Integer numberOfAxes;
}
