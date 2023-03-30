package jpa.study.domain.persistance.eleven.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@DiscriminatorValue("B")
@Entity
public class Book extends Item{

    private String author;
    private String isbn;
}
