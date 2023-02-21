package jpa.study.domain.persistance.six;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipzone;

    public Member(String name) {
        this.name = name;
    }

    public Member() {

    }
}
