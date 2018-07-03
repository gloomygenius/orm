package org.gloomygenius.orm.inheritance.join_table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Officer extends Military {
    private Integer lengthOfService;
}
