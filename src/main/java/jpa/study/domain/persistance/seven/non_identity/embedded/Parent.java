package jpa.study.domain.persistance.seven.non_identity.embedded;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {
    @EmbeddedId
    private ParentId id;

    private String name;
}
