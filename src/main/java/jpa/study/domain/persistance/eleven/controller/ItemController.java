package jpa.study.domain.persistance.eleven.controller;

import jpa.study.domain.persistance.eleven.domain.Book;
import jpa.study.domain.persistance.eleven.domain.Item;
import jpa.study.domain.persistance.eleven.service.ItemService;
import jpa.study.domain.persistance.eleven.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {
    private MemberService memberService;
    private ItemService itemService;


    public ItemController(@Autowired MemberService memberService,@Autowired ItemService itemService) {
        this.memberService = memberService;
        this.itemService = itemService;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/items")
    public ResponseEntity<List<Item>> list() {
        List<Item> items = itemService.findItems();

//        model.addAttribute("items", items);
//        String word = "hello";
        return ResponseEntity.ok(items);
    }

    @RequestMapping(path = "/items/new" , method=RequestMethod.GET)
    public String createForm() {
        return "items/createItemForm";
    }

    @PostMapping("/new")
    public String postForm(Book item) {

        itemService.save(item);

        return "redirect:/items/new";
    }

    @GetMapping("/items/news")
    public String createItems() {
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
        return "index";
    }

}
