package com.example.demo.service;

import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;
    public List<Order> findAll(){

        return orderRepo.findAll();
    }

    public Order save(Order order){

        return  orderRepo.save(order);
    }
}
