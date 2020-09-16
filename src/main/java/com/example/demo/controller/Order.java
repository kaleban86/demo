package com.example.demo.controller;

import com.example.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class Order {



    private final OrderRepo orderRepo;

    public Order(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @RequestMapping(value = "/order-history", method = RequestMethod.GET)
    public String test(String name, Model model) {

        model.addAttribute("name",model);


        return "/order-history";
    }



    @RequestMapping(value = "/new-order", method = RequestMethod.GET)
    public String newOrder(String name,Model model){


        return "/new-order";

    }


    @RequestMapping(value =  "/order-add", method = RequestMethod.POST)
    public String addOrder( Model model, @RequestParam String client, String address, String name){

        com.example.demo.models.OrderId order = new com.example.demo.models.OrderId(client, address ,name);

        orderRepo.save(order);

        return "redirect:/order-history";
    }



}
