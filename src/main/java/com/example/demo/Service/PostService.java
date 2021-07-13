package com.example.demo.Service;

import org.codehaus.jettison.json.JSONException;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository  postRepository;

	public  ResponseEntity<?>  createPost(PostModel post) throws JSONException{
		if (post!=null) {
			postRepository.save(post);
			return new ResponseEntity<>(returnJsonString(true, "Post Created"),
                    HttpStatus.CREATED);
        } else {
        	return new ResponseEntity<>(returnJsonString(false, "Post NotCreated"),
                    HttpStatus.FORBIDDEN);
        }
		
	}
	public String returnJsonString(boolean status, String response) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", response);
        return jsonObject.toString();
    }
}
