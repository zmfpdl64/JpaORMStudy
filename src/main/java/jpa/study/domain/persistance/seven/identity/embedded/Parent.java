package jpa.study.domain.persistance.seven.identity.embedded;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {
    @Id @Column(name = "parent_id")
    private String id;
    private String name;
}
