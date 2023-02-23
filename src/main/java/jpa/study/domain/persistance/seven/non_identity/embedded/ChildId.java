package jpa.study.domain.persistance.seven.non_identity.embedded;

import javax.persistence.Column;
import java.io.Serializable;

public class ChildId implements Serializable {
    @Column(name = "parent")
    private Parent parent;
    @Column(name = "child_id")
    private String id;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
