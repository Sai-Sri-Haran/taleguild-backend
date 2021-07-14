package com.example.demo.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PostService;
import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;

@RestController
@RequestMapping(value = "/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value = "/createpost",method = RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody PostModel post) throws JSONException{
		return postService.createPost(post);
	}
	
	@RequestMapping(value = "/getallpost",method = RequestMethod.GET)
	public ResponseEntity<?> getallPost() throws JSONException{
		List<PostModel> post=postRepository.findAll();
		if(post.size()>0)
			return new ResponseEntity<List<PostModel>>(post,HttpStatus.OK);
		else
			return new ResponseEntity<>(returnJsonString(false,"No Stories Found"), HttpStatus.OK);
		}
	@RequestMapping(value = "/getpostbyid/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getpostbyId(@PathVariable long id) throws JSONException{
		return postService.getpostbyId(id);
	}
//	@RequestMapping(value = "/getbyemail/{email}",method = RequestMethod.GET)
//	public ResponseEntity<?> getpostbyEmail(@PathVariable String email) throws JSONException{
//		return postService.getpostbyEmail(email);
//	}
	
	@RequestMapping(value="/deletebyid/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deletebyId(@PathVariable long id) throws JSONException{
		return postService.deletebyId(id);
	}
	
	@RequestMapping(value = "/updatebyid/{id}",method = RequestMethod.PUT)
	 	public ResponseEntity<?> updatebyId(@RequestBody  PostModel post, @PathVariable long id) throws JSONException{
		return postService.updatebyId(post,id);
	}
	
	public String returnJsonString(boolean status, String response) throws JSONException  {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", response);
        return jsonObject.toString();
	}
}
