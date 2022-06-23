package com.simplilearn.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    private Integer price;
    private String category;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails=new HashSet<>();

    public Product(String name, Integer price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
