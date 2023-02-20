package jpa.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class Basicrepository {
    private EntityManager em;

    public Basicrepository(@Autowired EntityManager em) {
        this.em = em;
    }

}
