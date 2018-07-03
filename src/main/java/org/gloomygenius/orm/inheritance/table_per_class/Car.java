package org.gloomygenius.orm.inheritance.table_per_class;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private County manufacturer;
}
