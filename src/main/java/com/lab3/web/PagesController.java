package com.lab3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(value = "*")
@Controller
public class PagesController {
    @GetMapping(path = {"*"})
    public String getStartPage() {
        return "page1";
    }

    @GetMapping(path = "/page2")
    public String getSecondPage() {
        return "page2";
    }

    @GetMapping(path = "/page3")
    public String getThirdPage() {
        return "page3";
    }

}