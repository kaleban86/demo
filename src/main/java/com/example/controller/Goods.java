package com.example.controller;

import com.example.repository.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class Goods {


    private  GoodsRepo goodsRepo;

    public void setGoods(GoodsRepo goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String test(String name, Model model) {

        model.addAttribute("name",model);


        return "/goods";
    }



    @RequestMapping(value = "/goods-add",method = RequestMethod.GET)
    public String add(String name,Model model){

        model.addAttribute("name",name);

        return "/goods-add";
    }


    @RequestMapping(value = "/new-goods",method = RequestMethod.POST)
    public String newGoods(Model model, @RequestParam String name, @RequestParam BigDecimal price){


        com.example.models.Goods goods = new com.example.models.Goods(name,price);

        goodsRepo.save(goods);
        return "redirect:/goods";
    }


}
