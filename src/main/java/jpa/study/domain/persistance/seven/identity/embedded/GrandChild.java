package jpa.study.domain.persistance.seven.identity.embedded;

import javax.persistence.*;

@Entity
public class GrandChild {
    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "child_id"),
            @JoinColumn(name = "parent_id")
    })
    private Child child;

    private String name;
}
