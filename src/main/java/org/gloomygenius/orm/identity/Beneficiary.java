package org.gloomygenius.orm.identity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR") //сам генератор находится в package-info.java
    private Long id;
}
