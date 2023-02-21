package jpa.study.domain.persistance.six;


import lombok.Getter;
import org.hibernate.criterion.Order;

import javax.persistence.*;

@Getter
@Entity
public class Delivery {
    @Column(name = "delivery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    @OneToOne(mappedBy = "delivery")
    private Orders order;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        READY, COMP
    }
}
