package jpa.study.domain.persistance.five;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="product")
@Entity
public class Product {
    @Column(name="product_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private String productName;

    @ManyToMany(mappedBy = "products")
    List<Member> members = new ArrayList<>();

    public Product(String productName) {
        this.productName = productName;
    }

    public Product() {

    }
}
