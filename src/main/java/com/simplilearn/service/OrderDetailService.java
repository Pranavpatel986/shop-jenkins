package com.simplilearn.service;

import com.simplilearn.model.OrderDetail;
import com.simplilearn.repo.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    Optional<OrderDetail> findById(Long id) {
        return orderDetailRepo.findById(id);
    }

    public void save(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }

    public List<OrderDetail> getOrdersList() {
        return orderDetailRepo.findAll();
    }
}
