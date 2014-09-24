package com.hp.manner.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.manner.model.ResponseTemplate;
import com.hp.manner.model.TableName;
import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import com.hp.manner.service.UserServiceImpl;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	@Autowired
    private UserServiceImpl userService;
	@Autowired
    private UserRepository userRepository;
	@RequestMapping("/users")
	public List<User> listAllUsers(){
		return userService.listAllUsers();
	}
	@RequestMapping("/userByEmail")
	public User userByEmail(String email){
		return userService.getUserByEmail(email);
	}
	@RequestMapping("/userById")
	public ResponseTemplate userById(String userId){
		ResponseTemplate response=new ResponseTemplate();
		List<Object> listUser=new ArrayList<Object>();
		listUser.add(userRepository.findOne(new ObjectId(userId)));
		response.addData(TableName.User,listUser);
		return response;
	}
}
