package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api")
public class DemoController {

    @Autowired
    DemoServiceImpl demoService;

    @GetMapping("/v1")
    public String returnTemplate(ModelMap modelMap){
        modelMap.addAttribute("listPerson", demoService.listElements());
        return "template";
    }

    @GetMapping("/v2/{id}")
    @ResponseBody
    public Person returnJson(@PathVariable String id){
        return demoService.elementById(id);
    }

}
