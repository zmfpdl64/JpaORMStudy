package jpa.study.domain.persistance.seven.identity.idclass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(GrandChildId.class)
public class GrandChild {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "child_id"),
            @JoinColumn(name = "parent_id")
    })
    private Child child;

    @Id @Column(name="grandchild_id")
    private String grandChildId;

    private String name;
}
