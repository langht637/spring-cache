package com.guigu.service;

import com.guigu.entities.Employee;
import com.guigu.mapper.EmployeeMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Resource
    EmployeeMapper EmployeeMapper;

    @CachePut(key ="#result.id")
    public void insertEmployee( Employee employee){
       EmployeeMapper.insertEmployee(employee);
    }

    @Cacheable(key = "#id")
    public Employee findEmployeeById(Integer id){
        Employee ee = EmployeeMapper.getEmpById(id);
        return ee;
    }

    @RabbitListener(queues = "atguigu")
    public void Book(Employee employee){
        System.out.print(employee.toString());
    }


}
