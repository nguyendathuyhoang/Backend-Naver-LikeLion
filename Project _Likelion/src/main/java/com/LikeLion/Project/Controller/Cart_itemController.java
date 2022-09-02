package com.LikeLion.Project.Controller;

import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Service.Cart_itemService;
import com.LikeLion.Project.Service.CustomerService;
import com.LikeLion.Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart_item")
public class Cart_itemController {
    @Autowired
    Cart_itemService cart_itemService;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @GetMapping("/findAllItem")
    public List<Cart_item> findAllItem()
    {
        return cart_itemService.findAllItem();
    }

    @GetMapping("/findAll1/{customer_id}/{name_product}/{offset}/{limit}")
    public List<Cart_item> findALL1(@PathVariable int customer_id, @PathVariable String name_product,
                                    @PathVariable int offset, @PathVariable int limit)
    {
        return cart_itemService.findAll1(customer_id,name_product,offset,limit);
    }

    @PostMapping("/add/{customer_id}/{product_id}/{quantity_wished}")
    public String addCartItem(@PathVariable int customer_id, @PathVariable int product_id,
                                       @PathVariable int quantity_wished )
    {
        int countProduct = cart_itemService.countProduct_id(product_id);
        if (countProduct==0)
        {
            cart_itemService.addCartItem(customer_id,product_id,quantity_wished);
        }
        else {
            cart_itemService.editCartItem(customer_id,product_id,quantity_wished);

        }

        return "Successfully!";
    }
}
