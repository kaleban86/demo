package com.example.controller;

import com.example.repository.OrderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Order {




    @RequestMapping(value = "/order-history", method = RequestMethod.GET)
    public String test(String name, Model model) {

        model.addAttribute("name",model);


        return "/order-history";
    }
}
