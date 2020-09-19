package com.example.demo.repository;

import com.example.demo.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepo  extends JpaRepository<OrderLine,Long> {



}
