package com.guigu.controller;

import com.guigu.entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class EmployController {


    @RequestMapping("/employee")
    public Employee getEmploy(Employee ee){
        return ee;
    }

    @RequestMapping("/first")
    public ModelAndView first(){
        return new ModelAndView("first");
    }
}
