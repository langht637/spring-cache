package com.guigu;

import com.guigu.entities.Employee;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableCaching
@EnableRabbit
@EnableOpenApi
public class SpringCacheMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheMain.class,args);
    }



}
