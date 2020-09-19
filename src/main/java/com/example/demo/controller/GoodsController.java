package com.example.demo.controller;

import com.example.demo.models.Goods;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @GetMapping("/goodsMain")
    public String findAll(String name, Model model) {
        model.addAttribute("goods", goodsService.findAll());
        return "/goodsMain";
    }


    @GetMapping("/goods-add")
    public String add(String name, Model model) {
        model.addAttribute("name", name);
        return "/goods-add";
    }


    @PostMapping("/goods-add")
    public String createGoods(@RequestParam String name, @RequestParam BigDecimal price) {
        goodsService.save(new Goods(name, price));
        return "redirect:/goodsMain";
    }


    @GetMapping("/goods/{id}")
    public String updateGoods(Goods goods, Model model, @PathVariable Long id) {
        model.addAttribute("goods", goodsService.findById(id));


        return "/goods-update";
    }

    @PostMapping("/goods")
    public String save(Goods goods, Model model){
        model.addAttribute("goods", goodsService.save(goods));
         return "redirect:/goodsMain";
    }


    @GetMapping("/goods-delete/{id}")
    public String goodsDelete(@PathVariable Long id) {
        goodsService.delete(id);
        return "redirect:/goodsMain";
    }
}
