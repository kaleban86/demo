package com.example.demo.models;
import javax.persistence.*;


@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId")
    private Goods goodsId;

    private Long count;


    public OrderLine() {
    }

    public OrderLine(Long id, Order orderId, Goods goodsId, Long count) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.count = count;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Goods getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Goods goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
