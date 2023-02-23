package jpa.study.domain.persistance.seven.identity.idclass;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {
    @Id
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Parent parent;

    @Id @Column(name="child_id")
    private String childId;

    private String name;
}
