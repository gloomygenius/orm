package org.gloomygenius.orm.inheritance.table_per_class;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Bulldozer extends Car {
    /**
     * Подъём отвала у бульдозера, в мм
     */
    private Integer liftingBlade;
}
