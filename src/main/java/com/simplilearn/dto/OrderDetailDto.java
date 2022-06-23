package com.simplilearn.dto;

import com.simplilearn.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailDto {
    private Product product;
    private int quantity;
}
