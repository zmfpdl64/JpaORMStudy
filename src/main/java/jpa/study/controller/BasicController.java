package jpa.study.controller;

//import jpa.study.domain.persistance.five.Member;
//import jpa.study.domain.persistance.five.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;

@Transactional
@Controller
@Slf4j
public class BasicController {
    private EntityManager em;

    public BasicController(@Autowired EntityManager em) {
        this.em = em;
    }

    @GetMapping("/")
    public String basic() {
//        Member member1 = new Member("name1");
//        Order order1 = new Order();
//        Order order2 = new Order();
//        order1.setMember(member1);
//        order2.setMember(member1);
//
//        em.persist(order1);
//        em.persist(order2);
//        em.persist(member1);

        log.info("basic page");
        return "index";
    }
}
