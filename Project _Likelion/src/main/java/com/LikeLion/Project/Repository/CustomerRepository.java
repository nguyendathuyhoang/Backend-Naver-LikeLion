package com.LikeLion.Project.Repository;

import com.LikeLion.Project.Entity.Custormer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface CustomerRepository {
    @Select("select cart_id from customer where customer_id=#{customer_id}")
    int getById(int customer_id);
}
