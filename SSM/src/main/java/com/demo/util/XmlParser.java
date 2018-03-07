package com.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class XmlParser {

	public static Map getXmlElmentValue(String xml) {

		try {

			Document doc = DocumentHelper.parseText(xml);
			Element el = doc.getRootElement();
			Map map = new HashMap();
			
			xmlSearch(el, map);
			return map;
		} catch (Exception e) {
			
			return null;
		}
	}

	private static void xmlSearch(Element elemParent, Map map) {

		String strValue = "";
		String strName = "";
		List elemsChild = elemParent.elements();

	
		if (elemsChild.size() > 0) {
			for (int i = 0; i < elemsChild.size(); i++) {
				xmlSearch((Element) elemsChild.get(i), map);
			}
		}
		
		else {

			strValue = (String) (elemParent.getData());
			strName = elemParent.getName();
			map.put(elemParent.getName(), strValue);

		}
	}
	
	public static String resultXML(String xml,String toUser,String fromUser){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA["+fromUser+"]]></ToUserName>");
		sb.append("<FromUserName><![CDATA["+toUser+"]]></FromUserName>");
		sb.append("<CreateTime>"+new Date().getTime()+"</CreateTime>");
		sb.append(xml);
		sb.append("</xml>");
		return sb.toString();
	}
	
	
	
	
	
	
	
}
