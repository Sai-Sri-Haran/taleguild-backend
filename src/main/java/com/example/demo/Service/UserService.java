package com.example.demo.Service;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public  ResponseEntity<?>  addUser(UserModel user) throws JSONException{
		UserModel exist= userRepository.findByEmail(user.getEmail());
		if (exist != null) {
            return new ResponseEntity<>(returnJsonString(false, "Email already exist please try with new mail","null"),
                    HttpStatus.FORBIDDEN);
        } else {
            userRepository.save(user);
            return new ResponseEntity<>(returnJsonString(true, "SignIn success ","null"),
                    HttpStatus.CREATED);
        }
		
	}
	public ResponseEntity<?>  loginUser(UserModel user)throws JSONException{
		UserModel res_data = userRepository.findByEmail(user.getEmail());
		JSONObject jsonObject = new JSONObject();
		  if(res_data==null) {
			  return new ResponseEntity<>(returnJsonString(false, "Login Failed","null"),
	                  HttpStatus.FORBIDDEN); 
			  }

		  else {
			  if(res_data.getPassword().equals(user.getPassword())){
				  jsonObject.put("email", user.getEmail());
				  jsonObject.put("username",res_data.getUsername());
			  return new ResponseEntity<>(returnJsonString(true, "Login Success",jsonObject.toString()),
	                  HttpStatus.OK);
		  }
			  return new ResponseEntity<>(returnJsonString(false, "Login Failed","null"),
                  HttpStatus.FORBIDDEN); 
			  
	}
}
	public String returnJsonString(boolean status, String response,String cred) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", response);
        jsonObject.put("cred", cred);
        return jsonObject.toString();
    }
}
