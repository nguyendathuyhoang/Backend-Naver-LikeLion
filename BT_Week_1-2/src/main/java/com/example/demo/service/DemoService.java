package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DemoService<T> {

    List<T> listElements();
    T elementById(String id);
}
