package jpa.study.domain.persistance.eleven.controller;

import jpa.study.domain.persistance.eleven.domain.Book;
import jpa.study.domain.persistance.eleven.domain.Item;
import jpa.study.domain.persistance.eleven.domain.Member;
import jpa.study.domain.persistance.eleven.service.ItemService;
import jpa.study.domain.persistance.eleven.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private MemberService sut;
    private ItemService itemService;

    public MainController(@Autowired MemberService sut, @Autowired ItemService itemService) {
        this.sut = sut;
        this.itemService = itemService;
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

            Item item1 = new Book();
            item1.setName("jpa");
            item1.setPrice(10_000);
            item1.setStockQuantity(10);

            Item item2 = new Book();
            item2.setName("React");
            item2.setPrice(5_000);
            item2.setStockQuantity(5);

            Item item3 = new Book();
            item3.setName("Spring Boot");
            item3.setPrice(8_000);
            item3.setStockQuantity(5);

            itemService.save(item1);
            itemService.save(item2);
            itemService.save(item3);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return "index";
    }
}
