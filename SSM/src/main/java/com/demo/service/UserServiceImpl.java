package com.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.Dept;
import com.demo.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userdao;
	@Override
	public List<User> findUsers(User user) {
		return userdao.findusers(user);
	}
	
	@Override
	public void addusers(User user) {
		userdao.addusers(user);
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}

	@Override
	public User finduserById(Integer uid) {
		return userdao.finduserById(uid);
	}

	@Override
	public List<Dept> finddept() {
		return userdao.finddept();
	}

	@Override
	public void deleteuser(Integer uid) {
		userdao.deleteuser(uid);		
	}

	@Override
	public Integer getcount(User user) {
		return userdao.getcount(user);
	}

	@Override
	public Integer login(User user) {
		return userdao.login(user);
	}

}
