package jpa.study.domain.persistance.seven.per;

import jpa.study.domain.persistance.seven.per.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Book extends Item {

    private String author;
    private String isbn;

}
