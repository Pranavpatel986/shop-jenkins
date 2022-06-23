package com.simplilearn.controller;

import com.simplilearn.dto.OrderDetailDto;
import com.simplilearn.model.OrderDetail;
import com.simplilearn.model.Product;
import com.simplilearn.service.OrderDetailService;
import com.simplilearn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public String customerHome(Model m){
        List<Product> products=productService.getProductList();
        m.addAttribute("productList",products);
        return "CustomerHome";
    }
    @PostMapping("/makeOrder")
    public String order(@ModelAttribute OrderDetailDto orderDetailDto){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal= auth.getPrincipal();
        String Customer="";
        if (principal instanceof UserDetails){
            Customer=( (UserDetails)principal).getUsername();
        }
        else {
            Customer=principal.toString();
        }
        Product product=orderDetailDto.getProduct();
        int quantity=orderDetailDto.getQuantity();
        float total= product.getPrice()*quantity;
        OrderDetail orderDetail=new OrderDetail(product,quantity,Customer,total);
        orderDetailService.save(orderDetail);

        return "redirect:/orders?success";
    }

    @GetMapping("/product/{id}")
    public String orderDetails(@PathVariable Long id,Model m){


        Product product=productService.getProductById(id).get();
        OrderDetailDto orderDetailDto=new OrderDetailDto(product,1);
        m.addAttribute("orderDetailDto",orderDetailDto);

        return "OrderDetail";
    }
    @GetMapping("/showOrders")
    public String showOrders(){
        return "OrderList";
    }
    @ModelAttribute("ordersList")
    public List<OrderDetail> orderDetailList(){
        return orderDetailService.getOrdersList();
    }

}

