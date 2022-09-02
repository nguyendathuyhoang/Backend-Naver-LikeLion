package com.LikeLion.Project.Service;

import com.LikeLion.Project.DTO.ProductDTO;
import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByLessThan(double price);
    List<Product> findByGreaterThan(double price);
    List<Product> findByEqualTo(double price);


    List<Product> findAll();
    //List<Product> InsertProduct(Product product);

    List<Product> findById(int id);

    int getQuantity(int product_id);

    double getPrice(int product_id);


}
