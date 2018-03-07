package com.demo.util;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.demo.model.User;

public class MybatisTest {
	SqlSessionFactory ssf;
	SqlSession sqlSession;
	@Before
	public void init() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findUser() {
		List<User> ulList = sqlSession.selectList("mybatis_mapper.findUser");
		for (User user : ulList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findUserById() {
		User user = sqlSession.selectOne("mybatis_mapper.findUserById", 1);
		System.out.println(user);
		
	}
	@Test
	public void insertUser() {
		User user = new User();
		user.setUname("老刘子");
		user.setUsex("F");
		user.setAddress("湖北十堰");
		user.setEmail("54353@qq.com");
		sqlSession.insert("mybatis_mapper.insertUser", user);
		sqlSession.commit();
	}
	@Test
	public void updateUser() {
		User user = new User();
		user.setUid(1);
		user.setUname("老刘子");
		user.setUsex("M");
		user.setAddress("123354");
		user.setEmail("54353@qq.com");
		sqlSession.update("mybatis_mapper.updateUser", user);
		sqlSession.commit();
	}

}
