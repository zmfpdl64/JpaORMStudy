package jpa.study.domain.persistance.eleven;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@DiscriminatorValue("B")
@Entity
public class Book extends Item{

    private String author;
    private String isbn;
}
