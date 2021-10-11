package com.example.demo.servic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserServic {
	@Autowired
	RedisTemplate<Object, Object> template;

	public static final String KEY = "user";
	
	public void add(User user) {
		template.opsForHash().put(KEY ,user.getId(), user);
	}

	public void update(User user) {
		template.opsForHash().put(KEY,user.getId() , user);
	}
	
	public void delete(String userId) {
		template.opsForHash().delete(KEY, userId);
	}
	
	public User findById(String userId) {
		return (User)template.opsForHash().get(KEY, userId);
	}
	
	public List<User> findAll() {
		return template.opsForHash().scan(KEY,ScanOptions.NONE).stream().map((e)->{
			return (User)e.getValue();
		}).collect(Collectors.toList());
	}
}
