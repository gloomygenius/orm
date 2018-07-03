package org.gloomygenius.orm.inheritance.join_table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Military {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private ArmyType armyType;
}