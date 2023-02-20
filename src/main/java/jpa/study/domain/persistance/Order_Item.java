package jpa.study.domain.persistance;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="order_item")
public class Order_Item {

    @Column(name="order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    private void setOrder(Order order){
        order.getItems().add(this);
        this.order = order;
    }
    private void setOrder(){
        this.order.getItems().remove(this);
        this.order = null;
    }

}
