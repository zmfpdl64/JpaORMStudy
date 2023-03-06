package jpa.study.domain.persistance.eleven.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@DiscriminatorValue("B")
@Entity
public class Book extends Item{

    private String author;
    private String isbn;
}
