package com.LearnSphere.services;

import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Users;
import com.LearnSphere.repository.UserRepository;

@Service

public class UserServiceeImplementation implements UserService{
    UserRepository repo;
    
	public UserServiceeImplementation(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "Student added successfully";
	}

	@Override
	public boolean checkEmail(String email) {
	return repo.existsByEmail(email);
		
	}

	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			Users u=repo.getByEmail(email);
			String dbpassword=u.getPassword();
			if(password.equals(dbpassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
}

	@Override
	public String getUserRole(String email) {
		Users u=repo.getByEmail(email);
		return u.getRole();
	}
}


