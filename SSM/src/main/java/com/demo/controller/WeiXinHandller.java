package com.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.util.XmlParser;

@RequestMapping("hkl")
@Controller
public class WeiXinHandller {
	
	/*@RequestMapping(value="weixin",method=RequestMethod.GET)
	public @ResponseBody String in(HttpServletResponse response,String signature,String timestamp,String nonce,String echostr){
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
//		try {
//			response.getWriter().print(echostr);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return echostr;
	}*/
	
	@RequestMapping(value="weixin",method=RequestMethod.POST)
	public void  inmsg(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		BufferedReader sis = request.getReader();
		char[] buf = new char[1024];
		int len = 0;
		StringBuffer stringBuffer = new StringBuffer();
		while ((len = sis.read(buf)) != -1) {
			stringBuffer.append(buf, 0, len);
		}
		System.out.println(stringBuffer.toString());
		
		Map map = XmlParser.getXmlElmentValue(stringBuffer.toString());
		String toUser=map.get("ToUserName").toString();
		String fromUser = map.get("FromUserName").toString();
		StringBuffer returnmsg=new StringBuffer();
		
		//<MsgType><![CDATA[text]]></MsgType> <Content><![CDATA[你好]]></Content> 
		returnmsg.append("<MsgType><![CDATA[text]]></MsgType>");
		returnmsg.append("<Content><![CDATA[你好]]></Content>");
		String msg = XmlParser.resultXML(returnmsg.toString(), toUser, fromUser);
		response.getWriter().print(msg);
	}



}
