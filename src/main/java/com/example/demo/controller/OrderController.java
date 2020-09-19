package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping("/order")
    public String order(String name, Model model) {
        model.addAttribute("order", orderService.findAll());
        return "/order";
    }


    @GetMapping("/order-add")
    public String addOrder(@RequestParam String client, @RequestParam String address, @RequestParam String name) {
        orderService.save(new Order(client, address, name));
        return "/order-add";
    }


}
