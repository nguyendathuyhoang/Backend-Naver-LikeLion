package com.LikeLion.Project.Service.ServiceImpl;

import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Repository.Cart_itemRepository;
import com.LikeLion.Project.Repository.ProductRepository;
import com.LikeLion.Project.Service.Cart_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Cart_itemServiceImpl implements Cart_itemService {

    @Resource
    Cart_itemRepository cart_itemRepository;
    @Override
    public List<Cart_item> findAll1(int customer_id, String name_product, int offset, int limit) {
        List<Cart_item> products = cart_itemRepository.findAll1(customer_id,name_product,offset, limit);
        return  products;
    }

    @Override
    public List<Cart_item> findAllItem() {
        return cart_itemRepository.findAllItem();
    }

    @Override
    public void addCartItem(int customer_id, int product_id, int quantity_wished) {
        cart_itemRepository.addCartItem(customer_id, product_id, quantity_wished);
    }

    @Override
    public int countProduct_id(int product_id) {
        return cart_itemRepository.countProduct_id(product_id);
    }

    @Override
    public void editCartItem(int customer_id, int product_id, int quantity_wished) {
         cart_itemRepository.editCartItem(customer_id,product_id,quantity_wished);
    }


}
