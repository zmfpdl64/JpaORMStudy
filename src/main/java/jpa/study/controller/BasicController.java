package jpa.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class BasicController {
    @GetMapping("/")
    public String basic() {
        log.info("basic page");
        return "index";
    }
}
