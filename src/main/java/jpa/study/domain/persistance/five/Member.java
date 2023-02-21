package jpa.study.domain.persistance.five;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="member")
public class Member {

    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String street;

    private String zipcode;


    @OneToMany(mappedBy="member")
    private List<Order> orderList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="member_product",
    joinColumns = @JoinColumn(name="member_id"),
    inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public Member() {

    }
}
