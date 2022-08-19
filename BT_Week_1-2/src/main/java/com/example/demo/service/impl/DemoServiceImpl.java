package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService<Person> {

    private final DemoRepository demoRepository;

    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public List<Person> listElements() {
        return demoRepository.findAll();
    }

    @Override
    public Person elementById(String id) {
        return demoRepository.findById(id);
    }

}
