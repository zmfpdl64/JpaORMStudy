package jpa.study.domain.persistance.seven.per;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "DTYPE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private  Long id;

    private String name;
    private String price;
}
