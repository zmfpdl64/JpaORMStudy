package jpa.study.domain.persistance.eleven.controller;

import jpa.study.domain.persistance.eleven.domain.Member;
import jpa.study.domain.persistance.eleven.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private MemberService sut;

    public MainController(MemberService sut) {
        this.sut = sut;
    }

    @GetMapping("/")
    public String home() {
        try{
            //given
            Member member = new Member();
            member.setName("kim");
            //when
            Long join = sut.join(member);

            //then
            System.out.println(join);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return "index";
    }
}
