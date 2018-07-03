package org.gloomygenius.orm.inheritance.join_table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "soldier_id") //переопределение названия id (опционально)
public class Soldier extends Military {
    private String rank;
}
