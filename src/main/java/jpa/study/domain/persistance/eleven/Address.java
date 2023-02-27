package jpa.study.domain.persistance.eleven;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
