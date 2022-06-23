package com.simplilearn.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @Column(name = "order_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private String customer;
    private float total;


    public OrderDetail(Product product, int quantity, String customer, float total) {
        this.product = product;
        this.quantity = quantity;
        this.customer = customer;
        this.total = total;
    }
}
