package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface DAO {

	public void save(User user);
	public List<User> viewAllUser();
	public User getUserById(int id);
	public void update(User user);
	public void delete(int id);
	
}
