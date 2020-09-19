package com.example.demo.controller;

import com.example.demo.models.Goods;
import com.example.demo.models.Order;
import com.example.demo.models.OrderLine;
import com.example.demo.service.GoodsService;
import com.example.demo.service.OrderLineService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderLineController {



    @Autowired
    private  OrderLineService orderLineService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;


    @GetMapping( "/order-line")
    public String orderLine(Model model) {
        model.addAttribute("orderLine",orderLineService.findAll());
        return "/order-line";

    }


    @GetMapping("/order-line-add")
    public String order(Model model) {
        List<Goods> listGoods = goodsService.findAll();
        model.addAttribute("listGoods", listGoods);
        List<Order> orderIdList = orderService.findAll();
        model.addAttribute("orderIdList", orderIdList);
        return "order-line-add";
    }
    @PostMapping("/order-line-add")
    public String orderLineAdd(Model model,OrderLine orderLine) {
        List<Goods> listGoods = goodsService.findAll();
        model.addAttribute("listGoods", listGoods);
        List<Order> orderIdList = orderService.findAll();
        model.addAttribute("orderIdList", orderIdList);
        orderLineService.save(orderLine);
        return "redirect:/order-line";
    }


    @GetMapping("/order-line/{id}")
    public String orderLineUpdate(@PathVariable Long id, Model model) {
        List<Goods> listGoods = goodsService.findAll();
        model.addAttribute("listGoods", listGoods);
        List<Order> orderIdList = orderService.findAll();
        model.addAttribute("orderIdList", orderIdList);
        OrderLine orderLine = orderLineService.findById(id);
        model.addAttribute("line", orderLine);
        orderLineService.save(orderLine);
        return "/order-line-update";

    }

    @PostMapping(value = "/order-line-update")
    public String saveOrderLine(OrderLine orderLine ) {

        orderLineService.save(orderLine);
        return "redirect:/order-line";
    }

    @GetMapping (value = "/order-line-delete/{id}")
    public String orderLineDelete(@PathVariable Long id) {
        orderLineService.delete(id);
        return "redirect:/order-line";

    }
}
