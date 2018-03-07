package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.model.Dept;
import com.demo.model.User;

public interface UserService{
	
	public List<User> findUsers(User user);
	public Integer getcount(User user);
	
	public List<Dept> finddept();
	
	public void addusers(User user);
	
	public User finduserById(Integer uid);
	
	public void updateUser(User user);
	
	public void deleteuser(Integer uid);
	public Integer login(User user);


}
