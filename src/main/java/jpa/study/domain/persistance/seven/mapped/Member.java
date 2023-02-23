package jpa.study.domain.persistance.seven.mapped;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "member_id")),
        @AttributeOverride(name = "name", column = @Column(name = "memeber_name"))
})
public class Member extends BaseEntity{
    private String Email;
}
