package jpa.study.domain.persistance.seven.per;

import jpa.study.domain.persistance.seven.per.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String director;
    private String actor;
}
