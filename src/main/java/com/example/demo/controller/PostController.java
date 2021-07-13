package com.example.demo.controller;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PostService;
import com.example.demo.model.PostModel;

@RestController
@RequestMapping(value = "/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/createpost",method = RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody PostModel post) throws JSONException{
		return postService.createPost(post);
	}
}
