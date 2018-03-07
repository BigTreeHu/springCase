package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.model.Dept;
import com.demo.model.User;
import com.demo.service.UserService;
@Controller
public class Hindller {
	
	@Autowired
	UserService service;
	
	@ResponseBody
	@RequestMapping("users")
	public Map finduser(User user,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map paraMap = new HashMap<>();
		List<User> ulist = service.findUsers(user);
		paraMap.put("ulist", ulist);
		return paraMap;
	}

	@RequestMapping("toadd")
	public String toadd(Map<String, Object> map) {
		List<Dept> dlist = service.finddept();
		map.put("dlist", dlist);
		return "add";
	}
	
	@ResponseBody
	@RequestMapping("adduser")
	public void adduser(User user,HttpServletResponse response) {
	 
		response.setHeader("Access-Control-Allow-Origin", "*");
		service.addusers(user);
	}
	
	@RequestMapping("toupdate")
	public String toupdate(Map<String, Object> map,Integer uid) {
		User user = service.finduserById(uid);
		map.put("dlist", service.finddept());
		map.put("user", user);
		return "updateuser";
	}
	
	@RequestMapping("updateuser")
	public String updateuser(Map<String, Object> map,User user) {
		service.updateUser(user);
		return "redirect:users";
	}
	
	@RequestMapping(value="/{deleteuser}",method=RequestMethod.GET)
	public void delete(Integer uid,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		service.deleteuser(uid);
	}
	
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Map login(User user,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map paramap = new HashMap();
		Integer count = service.login(user);
		String hu = "";
		if (count>0) {
			hu="success";
		}else {
			hu="error";
		}
		paramap.put("code", count);
		return paramap;
		//http://127.0.0.1:8080/SSM/login?uname=admin&password=123456
	}
}
