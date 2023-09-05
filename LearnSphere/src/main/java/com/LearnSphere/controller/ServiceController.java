package com.LearnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.entity.Users;
import com.LearnSphere.services.UserService;

@Controller

public class ServiceController {
	@Autowired
	UserService uservice;
@PostMapping("/adduser")
public String adduser(@RequestParam("name")String name,
		@RequestParam("email")String email,
		@RequestParam("password")String password,
		@RequestParam("role")String role) {
	boolean emailExists=uservice.checkEmail(email);
	  if (emailExists==false) {
	  Users user=new Users();
	  user.setName(name);
	  user.setEmail(email);
	  user.setPassword(password);
	  user.setRole(role);
	  uservice.addUser(user);
	  
	  System.out.println("User registered successfully");
	  	return "redirect:/login"; 
	  }
	  else {
		  System.out.println("User already exist");
	  	return "redirect:/register";
	  	}
}
@PostMapping("/validate")
public String validate (@RequestParam("email")String email,
		@RequestParam("password")String password){
 boolean val=uservice.validate(email, password);
 //if user is valid 
 if(val==true) {
	 if(uservice.getUserRole(email).equals("Student")) {
		 return "studentHome";
	 }
	 else {
		 return "trainerHome";
	 }
	
	
 }
 else {
	 System.out.println("Incorrect credentials,try again");
	 return "login";
 }
		
	
}
}

