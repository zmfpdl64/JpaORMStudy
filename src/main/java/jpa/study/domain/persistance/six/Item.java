package jpa.study.domain.persistance.six;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Item {
    @Column(name="item_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long Id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems = new ArrayList<>();

}
