package com.LikeLion.Project.Service.ServiceImpl;

import com.LikeLion.Project.Repository.CustomerRepository;
import com.LikeLion.Project.Service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerRepository customerRepository;


    @Override
    public int getById(int customer_id) {
        return customerRepository.getById(customer_id);
    }


}
