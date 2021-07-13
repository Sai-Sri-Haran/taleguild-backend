package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.UserModel;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public void addUser(@RequestBody  UserModel user) {
		userService.adduser(user);
	}
}
