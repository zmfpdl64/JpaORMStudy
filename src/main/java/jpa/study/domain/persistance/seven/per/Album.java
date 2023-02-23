package jpa.study.domain.persistance.seven.per;

import jpa.study.domain.persistance.seven.per.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Album extends Item {
    private String artist;
}
