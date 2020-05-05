package br.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author anand.
 * since on 27/5/18.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
