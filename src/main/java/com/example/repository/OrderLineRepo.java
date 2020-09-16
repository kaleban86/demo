package com.example.repository;

import com.example.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepo  extends JpaRepository<OrderLine,Long> {
}
