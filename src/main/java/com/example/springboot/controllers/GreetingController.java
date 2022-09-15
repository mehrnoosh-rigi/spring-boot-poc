package com.example.springboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController  {

    @GetMapping("/test")
    public String testprova()
    {
        return "test";
    }

    @GetMapping("/greeting")
    public String Greetings(
            Model model,
            @RequestParam(name="usr", required=false, defaultValue="World") String username,
            @RequestParam(name="col", required=false, defaultValue="#000000") String color
    )
    {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "greetings";
    }

}
