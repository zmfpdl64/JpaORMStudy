package jpa.study.domain.persistance;


import lombok.Data;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import javax.persistence.*;

@Data
@Entity
@Table(name="item")
public class Item {
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}
