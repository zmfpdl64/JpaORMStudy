package jpa.study.domain.persistance.seven.identity.embedded;


import javax.persistence.*;

@Entity
public class Child{
    @EmbeddedId
    private ChildId id;

    @MapsId("parent_id")
    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Parent parent;

    private String name;
}
