package com.example.demo.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody  UserModel user) throws JSONException {
		return userService.addUser(user);
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public ResponseEntity<?>   loginUser(@RequestBody  UserModel user) throws Exception {
		return userService.loginUser(user);
	}
	
	
}
