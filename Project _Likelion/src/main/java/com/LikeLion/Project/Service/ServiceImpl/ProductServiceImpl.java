package com.LikeLion.Project.Service.ServiceImpl;


import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;
import com.LikeLion.Project.Repository.ProductRepository;
import com.LikeLion.Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductRepository productRepository;


    @Override
    public List<Product> findByLessThan(double price) {
        List<Product> product = productRepository.findByLessThan(price);
        return product;
    }

    @Override
    public List<Product> findByGreaterThan(double price) {
        List<Product> product = productRepository.findByGreaterThan(price);
        return product;
    }

    @Override
    public List<Product> findByEqualTo(double price) {
        List<Product> product = productRepository.findByEqualTo(price);
        return product;
    }


    @Override
    public List<Product> findAll() {
        List<Product> products =productRepository.findAll();
        return  products;
    }

    @Override
    public List<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public int getQuantity(int product_id) {
        return productRepository.getQuantity(product_id);
    }

    @Override
    public double getPrice(int product_id) {
        return productRepository.getPrice(product_id);
    }

    public String getNameProduct(String name_product)
    {
        return productRepository.getNameProduct(name_product);
    }

}
