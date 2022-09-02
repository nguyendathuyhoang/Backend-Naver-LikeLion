package com.LikeLion.Project.Repository;

import com.LikeLion.Project.Entity.Cart_item;
import com.LikeLion.Project.Entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {
    @Select("select * from product where price < #{price}")
    @Results(value = { @Result(property = "product_id", column="product_id" ),
            @Result(property = "name_product", column="name_product" ),
            @Result(property = "type", column="type" ),
            @Result(property = "size", column="size" ),
            @Result(property = "price", column="price" )
    })
    List<Product> findByLessThan(double price);

    @Select("select * from product where price > #{price}")
    @Results(value = { @Result(property = "product_id", column="product_id" ),
            @Result(property = "name_product", column="name_product" ),
            @Result(property = "type", column="type" ),
            @Result(property = "size", column="size" ),
            @Result(property = "price", column="price" )
    })
    List<Product> findByGreaterThan(double price);

    @Select("select * from product where price = #{price}")
    @Results(value = { @Result(property = "product_id", column="product_id" ),
            @Result(property = "name_product", column="name_product" ),
            @Result(property = "type", column="type" ),
            @Result(property = "size", column="size" ),
            @Result(property = "price", column="price" )
    })
    List<Product> findByEqualTo(double price);

    @Select("select * from product")
    List<Product> findAll();

    @Select("select * from product where product_id=#{product_id}")
    List<Product> findById(int id);

    //Lấy tên sản phẩm
    @Select("select name_product from product where product_id=#{product_id}")
    String getNameProduct(String name_product);

    //Lấy số lượng
    @Select(("select quantity from product where product_id=#{product_id}"))
    int getQuantity(int product_id);

    //Lấy giá
    @Select("select price from product where product_id=#{product_id}")
    double getPrice(int product_id);


}
