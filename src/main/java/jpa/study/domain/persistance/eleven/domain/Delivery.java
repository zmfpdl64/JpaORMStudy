package jpa.study.domain.persistance.eleven.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "delivery")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public enum DeliveryStatus {
        READY, CANCEL, COMP
    }

    public Delivery (Address address) {
        this.setAddress(address);
    }

}
