package jpa.study.domain.persistance;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
