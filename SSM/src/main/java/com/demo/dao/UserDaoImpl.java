package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Dept;
import com.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<User> findusers(User user) {
		return sqlSession.selectList("user-mapper.findUser",user);
	}
	@Override
	public void addusers(User user) {
		sqlSession.insert("user-mapper.insertUser", user);
	}
	@Override
	public void updateUser(User user) {
		sqlSession.update("user-mapper.updateUser", user);
	}
	@Override
	public User finduserById(Integer uid) {
		return sqlSession.selectOne("user-mapper.findUserById",uid);
	}
	@Override
	public List<Dept> finddept() {
		return sqlSession.selectList("user-mapper.selectdept");
	}
	@Override
	public void deleteuser(Integer uid) {
		sqlSession.delete("user-mapper.deleteuser", uid);
	}
	@Override
	public Integer getcount(User user) {
		return sqlSession.selectOne("user-mapper.count", user);
	}
	@Override
	public Integer login(User user) {
		return sqlSession.selectOne("user-mapper.login", user);
	}

}
