package com.guigu.service;

import com.guigu.entities.Department;
import com.guigu.entities.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RabbitTemplate myRabbitTemplete;

    @Test
    public void test() {
        Employee employee = new Employee(50,"abc","abc",50,50);
       employeeService.insertEmployee(employee);
    }

    @Test
    public void testGet() {
        employeeService.findEmployeeById(2);
    }

    @Test
    public void testMq(){
        Employee employee = new Employee(50,"abc","abc",50,50);
        myRabbitTemplete.convertAndSend("exchange.fanout","",employee);
//        Object employ = myRabbitTemplete.receiveAndConvert("atguigu.emps");
//        System.out.print(employ);
    }


}