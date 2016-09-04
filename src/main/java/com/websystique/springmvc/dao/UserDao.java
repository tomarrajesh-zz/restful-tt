package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserDao {
	void saveUser(User user);
	
	void updateUser(User user);

	User findById(int id);

	List<User> findAllUsers();
	
	User findUserByName(String name);

}
