package com.simplilearn.controller;

import com.simplilearn.dto.ProductCreationDto;
import com.simplilearn.dto.UserRegistrationDto;
import com.simplilearn.model.Product;
import com.simplilearn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public String productList(Model model){
        return "ListProducts";
    }

    @GetMapping("/addProduct")
    public String addNewProduct(){
        return "AddProduct";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model m){
        Product product=productService.getProductById(id).get();
        if (product==null){
            throw new UsernameNotFoundException("Product Not Found");
        }
        m.addAttribute("productToEdit",product);

        return "EditProduct";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/product?deleted";
    }

    @PostMapping
    public String addProduct(@ModelAttribute ProductCreationDto dto){
        Product product=new Product(dto.getName(),dto.getPrice(),dto.getCategory());
        productService.save(product);
        return "redirect:/product?success";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("productToEdit") Product product){
        productService.update(product);
        return "redirect:/product?updated";
    }

    @ModelAttribute("product")
    public ProductCreationDto productDto() {
        return new ProductCreationDto();
    }

    @ModelAttribute("productList")
    public List<Product> productList() {
        return productService.getProductList();
    }
}
