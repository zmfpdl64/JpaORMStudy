package jpa.study.domain.persistance.six;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class OrderItem {
    @Column(name="orderitem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="orderitems")
    private Orders order;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    private Integer price;

    private Integer count;
}
