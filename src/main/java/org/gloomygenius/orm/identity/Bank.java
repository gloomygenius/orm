package org.gloomygenius.orm.identity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
