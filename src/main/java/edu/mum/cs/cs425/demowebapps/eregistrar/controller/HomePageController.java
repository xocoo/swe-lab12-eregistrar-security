package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "", "/eregistrar" })
public class HomePageController {
    @GetMapping(value = { "/", "/public/home" })
    public String displayHomePage() {
        return "public/home/index";
    }

    @GetMapping(value = { "/public/about" })
    public String displayAboutPage() {
        return "public/home/about";
    }
}
