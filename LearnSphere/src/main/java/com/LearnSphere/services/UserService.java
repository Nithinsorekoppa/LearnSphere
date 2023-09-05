package com.LearnSphere.services;

import com.LearnSphere.entity.Users;

public interface UserService {
	//adds new user to database
	String addUser(Users user);
	//checks email is already present in database or not
    boolean checkEmail(String email);
    //validate user's credentials
    boolean validate (String email,String password);
    //get user's role by providing email
    String getUserRole(String email);
}
