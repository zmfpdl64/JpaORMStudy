package jpa.study.domain.persistance.seven.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Item {

    private String author;
    private String isbn;

}
