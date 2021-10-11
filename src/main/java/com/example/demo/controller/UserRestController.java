package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.servic.UserServic;

@RestController
public class UserRestController {

	@Autowired
	UserServic servic;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return ResponseEntity.ok(servic.findById(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(servic.findAll());
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody User user) {
		servic.add(user);
		return ResponseEntity.ok("ok");
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody User user) {
		servic.update(user);
		return ResponseEntity.ok("ok");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		servic.delete(id);
		return ResponseEntity.ok("ok");
	}

}
