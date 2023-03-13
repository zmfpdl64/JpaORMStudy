package jpa.study.domain.persistance.eleven.controller;

import jpa.study.domain.persistance.eleven.domain.Book;
import jpa.study.domain.persistance.eleven.domain.Item;
import jpa.study.domain.persistance.eleven.service.ItemService;
import jpa.study.domain.persistance.eleven.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {
    private MemberService memberService;
    private ItemService itemService;

    @Autowired
    public ItemController(MemberService memberService, ItemService itemService) {
        this.memberService = memberService;
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/new")
    public String createForm() {
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String postForm(Book item) {

        itemService.save(item);

        return "redirect:/items/new";
    }

}
