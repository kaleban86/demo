package com.example.repository;

import com.example.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepo extends JpaRepository<Goods,Long>  {


}
