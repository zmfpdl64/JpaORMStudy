package jpa.study.domain.persistance;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Column(name = "order_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<Order_Item> items = new ArrayList<>();

    private void setMember(Member member){
        member.getOrderList().add(this);
        this.member = member;
    }
    private void setMember() {
        this.member.getOrderList().remove(this);
        this.member = null;
    }
    public enum OrderStatus {
        ORDER, CACEL
    }

}
