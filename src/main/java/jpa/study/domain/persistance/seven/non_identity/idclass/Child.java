package jpa.study.domain.persistance.seven.non_identity.idclass;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1",
                referencedColumnName = "parent_id1"),
            @JoinColumn(name = "parent_id2",
                referencedColumnName = "parent_id2")
    })
    private Parent parent;
}
