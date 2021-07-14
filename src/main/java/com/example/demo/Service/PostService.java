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
	private PostRepository postRepository;

	public ResponseEntity<?> createPost(PostModel post) throws JSONException {
		if (post != null) {
			postRepository.save(post);
			return new ResponseEntity<>(returnJsonString(true, "Post Created"), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(returnJsonString(false, "Post NotCreated"), HttpStatus.FORBIDDEN);
		}

	}

	public ResponseEntity<?> getpostbyId(long id) throws JSONException {
		PostModel post = postRepository.findById(id).get();
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		return new ResponseEntity<>(returnJsonString(false, "Post NotCreated"), HttpStatus.FORBIDDEN);
	}

	public String returnJsonString(boolean status, String response) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", status);
		jsonObject.put("message", response);
		return jsonObject.toString();
	}

	public ResponseEntity<?> deletebyId(long id) throws JSONException {
		try {
			postRepository.deleteById(id);
			return new ResponseEntity<>(returnJsonString(true, "Post deleted successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(returnJsonString(false, "Post NotCreated"), HttpStatus.FORBIDDEN);
	}
//	public ResponseEntity<?> getpostbyEmail(String email) throws JSONException {
//		PostModel post= postRepository.findByEmail(email);
//		if(post !=null) {
//			return new ResponseEntity<>(post,HttpStatus.OK);
//		}
//		return new ResponseEntity<>(returnJsonString(false, "Post NotCreated"), HttpStatus.FORBIDDEN);
//	}

	public ResponseEntity<?> updatebyId(PostModel post, long id) throws JSONException{
		PostModel exist = postRepository.findById(id).orElse(null);
		if(exist !=null) {
			exist.setEmail(post.getEmail());
			exist.setPostcategory(post.getPostcategory());
			exist.setPostcontent(post.getPostcontent());
			exist.setPostdescription(post.getPostdescription());
			exist.setPostimageurl(post.getPostimageurl());
			exist.setPostlanguage(post.getPostlanguage());
			exist.setPosttitle(post.getPosttitle());
			return new ResponseEntity<>(postRepository.save(exist), HttpStatus.OK);
		}
		return new ResponseEntity<>(returnJsonString(false, "user Not found"), HttpStatus.OK);
	}
}
