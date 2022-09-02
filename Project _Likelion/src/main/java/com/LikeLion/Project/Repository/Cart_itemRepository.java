package com.LikeLion.Project.Repository;

import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Cart_itemRepository {
    // Câu 5
    @Select("select i.* from customer c, cart_item i, product p where c.cart_id=i.cart_id " +
            "and i.product_id=p.product_id and c.customer_id=#{customer_id} and p.name_product=#{name_product}  "
            +" limit #{offset},#{limit}")
    List<Cart_item> findAll1(int customer_id, String name_product,  int offset, int limit);

    @Select("select * from cart_item")
    List<Cart_item> findAllItem();

    //Câu 3
    @Insert("insert into cart_item(cart_id, product_id,quantity_wished,total_amount)" +
            "values(" +
            "(select cart_id from customer where customer_id=#{customer_id}),#{product_id},#{quantity_wished}," +
            "(select #{quantity_wished}*price from product where product_id=#{product_id}))")
    void addCartItem(int customer_id, int product_id, int quantity_wished);

    // Count product_id
    @Select("select count(product_id) from cart_item where product_id=#{product_id}")
    int countProduct_id(int product_id);

    //Update cart_item
    @Update("update cart_item set " +
            "quantity_wished=#{quantity_wished}+quantity_wished, " +
            "total_amount=(select price from product where product_id=#{product_id})*quantity_wished " +
            "where cart_id=(select cart_id from customer where customer_id=#{customer_id}) and product_id=#{product_id}")
    void editCartItem(int customer_id, int product_id, int quantity_wished);

}
