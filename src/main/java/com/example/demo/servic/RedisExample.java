package com.example.demo.servic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class RedisExample implements CommandLineRunner {

	@Autowired
	private RedisTemplate<Object,Object> template;

	@Override
    public void run(String... args) throws Exception {
        listExample();
    }

    public void valueExample(){
        // Set giá trị của key "loda" là "hello redis"
        template.opsForValue().set("loda","hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key loda: "+template.opsForValue().get("loda"));
    }

    public void listExample(){

        // Set gia trị có key loda_list
//        template.opsForList().rightPushAll("loda_list", new User("1","a","a"));
//        template.opsForList().rightPushAll("loda_list", "hello", "world");
        System.out.println(template.opsForList().rightPop("loda_list"));
//        System.out.println(template.opsForList().remove("loda_list", 0, null));
        System.out.println(template.opsForList().size("loda_list"));
    }
}
