package jpa.study.domain.persistance.six;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class CategoryItem {
    @Column(name="categoryitem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
