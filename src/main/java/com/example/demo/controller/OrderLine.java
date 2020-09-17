package com.example.demo.controller;

import com.example.demo.models.Goods;
import com.example.demo.models.OrderId;
import com.example.demo.repository.GoodsRepo;
import com.example.demo.repository.OderLineRepo;
import com.example.demo.repository.OrderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrderLine {

    private final OderLineRepo oderLineRepo;
    private final GoodsRepo goodsRepo;
    private final OrderRepo orderRepo;

    public OrderLine(OderLineRepo oderLineRepo, GoodsRepo goodsRepo, OrderRepo orderRepo) {
        this.oderLineRepo = oderLineRepo;
        this.goodsRepo = goodsRepo;
        this.orderRepo = orderRepo;
    }


    @RequestMapping(value = "/order-line")
    public String orderLine(Model model) {


        model.addAttribute("orderLine", oderLineRepo.findAll());


        return "order-line";

    }


    @RequestMapping(value = "/order-line-add", method = RequestMethod.GET)
    public String orderLineAdd(Model model) {
        List<Goods> listGoods = goodsRepo.findAll();
        model.addAttribute("listGoods", listGoods);
        List<OrderId> orderIdList = orderRepo.findAll();
        model.addAttribute("orderIdList", orderIdList);
        return "/order-line-add";
    }


    @RequestMapping(value = "/order-line-new", method = RequestMethod.POST)
    public String orderLineNew(com.example.demo.models.OrderLine orderLine) {
        oderLineRepo.save(orderLine);
        return "redirect:/order-line";
    }


    @RequestMapping(value = "order-line-new", method = RequestMethod.GET)
    public String saveOrderLine(com.example.demo.models.OrderLine orderLine) {

        oderLineRepo.save(orderLine);

        return "redirect:/order-line";
    }


}
