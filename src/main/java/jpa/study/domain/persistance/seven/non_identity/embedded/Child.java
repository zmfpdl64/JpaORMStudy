package jpa.study.domain.persistance.seven.non_identity.embedded;

import javax.persistence.EmbeddedId;

public class Child {
    @EmbeddedId
    private ChildId id;

    private String name;
}
