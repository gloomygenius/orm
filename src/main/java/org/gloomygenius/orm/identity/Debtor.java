package org.gloomygenius.orm.identity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Debtor {
    @Id
    @GeneratedValue(generator = "debtor_generator")
    @SequenceGenerator(name = "debtor_generator", sequenceName = "debtor_sequence", allocationSize = 100) //JPA генератор
    private Long id;
}