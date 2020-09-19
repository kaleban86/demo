package com.example.demo.service;


import com.example.demo.models.Order;
import com.example.demo.models.OrderLine;
import com.example.demo.repository.OrderLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderLineService {


    @Autowired
    private OrderLineRepo orderLineRepo;
    public List<OrderLine> findAll(){

        return orderLineRepo.findAll();
    }

    public OrderLine findById(Long id){

        return orderLineRepo.findById(id).get();
    }


    public OrderLine save(OrderLine orderLine){

        return  orderLineRepo.save(orderLine);
    }


    public void delete(Long id){

        orderLineRepo.deleteById(id);
    }
}
