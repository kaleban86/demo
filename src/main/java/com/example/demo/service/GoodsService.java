package com.example.demo.service;

import com.example.demo.models.Goods;
import com.example.demo.repository.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class GoodsService {

    @Autowired
    private GoodsRepo goodsRepo;


    public List<Goods> findAll(){

        return goodsRepo.findAll();
    }

    public Goods findById(Long id){

        return goodsRepo.findById(id).get();
    }


    public Goods save(Goods goods){

        return  goodsRepo.save(goods);
    }


    public void delete(Long id){

        goodsRepo.deleteById(id);
    }



}
