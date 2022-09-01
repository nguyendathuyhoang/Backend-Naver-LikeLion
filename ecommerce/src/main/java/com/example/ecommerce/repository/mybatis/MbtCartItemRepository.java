package com.example.ecommerce.repository.mybatis;

import com.example.ecommerce.model.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface MbtCartItemRepository {
//    @Select("SELECT cart_item.* FROM customer, cart_item " +
//            "where customer.cart_id = cart_item.cart_id and customer.customer_id = #{customerId}")
//    @Results(value = {@Result(property="cartItemId", column="cart_item_id"),
//            @Result(property="cartId", column = "cart_id"),
//            @Result(property = "productId", column = "product_id"),
//            @Result(property = "quantityWished", column = "quantity_wished"),
//            @Result(property = "dateAdded", column = "date_added"),
//            @Result(property = "totalAmount", column = "total_amount")})
        @Select("SELECT cart_item.* " +
        "FROM customer, cart_item " +
        "where customer.cart_id = cart_item.cart_id " +
        "and customer.customer_id = #{customerId} " +
        "and cart_item.product_id in ( " +
        "select product_id " +
        "from product " +
        "where  name_product like '%#{nameProduct}%')")
        @Results(value = {@Result(property="customerId", column="customer_id"),
        @Result(property="customerName", column = "customer_name"),
        @Result(property = "customerAddress", column = "customer_address"),
        @Result(property = "phone_no", column = "phone_no"),
        @Result(property = "cartId", column = "cart_id"),
        @Result(property = "price", column = "price")})
        List<CartItem> findCartItemByCustomerIdAndProductName(Long customerId, String nameProduct);
}
