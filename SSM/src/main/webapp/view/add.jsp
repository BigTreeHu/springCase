<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="<%=basePath %>adduser" method="post">
		<table>
				<tr>
					<td>用户姓名：<input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>用户性别：<input type="radio" name="usex" value="M" checked="checked">男
					<input type="radio" name="usex" value="F" >女
					</td>
				</tr>
				<tr>
					<td>用户地址：<input type="text" name="address"></td>
				</tr>
				<tr>
					<td>用户邮箱：<input type="text" name="email"></td>
				</tr>
				<tr>
					<td>用户部门：<select name="did">
						<c:forEach items="${dlist }" var="dept">
							<option value="${dept.did }">${dept.dname }</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>