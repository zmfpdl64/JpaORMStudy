package jpa.study.domain.persistance.seven.identity.embedded;

import javax.persistence.Column;
import java.io.Serializable;

public class GrandChildId implements Serializable {
    private ChildId childId;

    @Column(name = "grandchild_id")
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
