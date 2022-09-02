package com.LikeLion.Project.Service;

import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;

import java.util.List;

public interface Cart_itemService {
    List<Cart_item> findAll1(int customer_id, String name_product, int offset, int limit);
    List<Cart_item> findAllItem();
    void addCartItem(int customer_id, int product_id, int quantity_wished);
    int countProduct_id(int product_id);
    void editCartItem(int customer_id, int product_id, int quantity_wished);
}
