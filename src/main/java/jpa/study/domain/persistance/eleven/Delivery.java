package jpa.study.domain.persistance.eleven;

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

    @OneToMany(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public enum DeliveryStatus {
        READY, CANCEL
    }

}
