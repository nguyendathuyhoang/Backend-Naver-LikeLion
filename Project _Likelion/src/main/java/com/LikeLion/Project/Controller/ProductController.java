package com.LikeLion.Project.Controller;

import com.LikeLion.Project.DTO.ProductDTO;
import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;
import com.LikeLion.Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/{price}/{condition}")
    public List<Product> findByPriceCondition(@PathVariable double price, @PathVariable String condition)
    {
        List<Product>  products = null;
        //List<Product> productList=new ArrayList<>();
        if(condition.equals("less_than")) {
            List<Product> productList = productService.findByLessThan(price);
            products=productList;
        } else if (condition.equals("greater_than")) {
            List<Product> productList = productService.findByGreaterThan(price);
            products=productList;
        }
        else {
            List<Product> productList = productService.findByEqualTo(price);
            products=productList;
        }

        return products;
    }


    @GetMapping("findAll")
    public List<Product> findALL()
    {
        return productService.findAll();
    }




}
