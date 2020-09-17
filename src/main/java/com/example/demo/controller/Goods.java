package com.example.demo.controller;

import com.example.demo.repository.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class Goods {


    private final GoodsRepo goodsRepo;

    public Goods(GoodsRepo goodsRepo) {
        this.goodsRepo = goodsRepo;
    }


    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String test(String name, Model model) {

        model.addAttribute("goods", goodsRepo.findAll());


        return "/goods";
    }


    @RequestMapping(value = "/goods-add", method = RequestMethod.GET)
    public String add(String name, Model model) {

        model.addAttribute("name", name);

        return "/goods-add";
    }


    @RequestMapping(value = "/new-goods", method = RequestMethod.POST)
    public String newGoods(Model model, @RequestParam String name, @RequestParam BigDecimal price) {


        com.example.demo.models.Goods goods = new com.example.demo.models.Goods(name, price);
        goodsRepo.save(goods);
        return "redirect:/goods";
    }


    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public String updateGoods(Goods goods, Model model, @PathVariable Long id) {

        Optional<com.example.demo.models.Goods> list = goodsRepo.findById(id);
        model.addAttribute("goods", list);


        return "/goods-update";
    }


    @RequestMapping(value = "goods-update", method = RequestMethod.POST)
    public String save(com.example.demo.models.Goods goods) {


        goodsRepo.save(goods);

        return "redirect:/goods";
    }


}
