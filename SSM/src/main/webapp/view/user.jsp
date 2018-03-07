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

	<form action="users" method="post" name="myform">
	    <input type="hidden" name="page" id="page">
		<table style="background: blue" width="700px">
			<tr style="background: white;">
				<td>
					用户姓名：<input type="text" name="uname" value="${user.uname }">
					用户部门：<select name="did">
							<option value="">请选择</option>
						<c:forEach items="${dlist }" var="d">
							<option value="${d.did }"  ${d.did==user.did?"selected='selected'":"" }>${d.dname }</option>
						</c:forEach>
					</select>
					<input type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
	
	<table style="background: blue" width="700px">
		<tr style="background: white;">
			<th>用户ID</th>
			<th>用户姓名</th>
			<th>用户性别</th>
			<th>用户地址</th>
			<th>用户邮箱</th>
			<th>用户部门</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${ulist }" var="user">
			<tr style="background: white;">
			<th>${user.uid }</th>
			<th>${user.uname }</th>
			<th>${user.usex=="M"?"男":"女" }</th>
			<th>${user.password }</th>
			<th>${user.email }</th>
			<th>${user.dname }</th>
			<td>
				<a href="<%=basePath %>toadd">添加</a>
				<a href="<%=basePath %>toupdate?uid=${user.uid }">修改</a>
				<a href="<%=basePath %>del?uid=${user.uid }">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<table style="background: blue" width="700px">
			<tr style="background: white;" align="center">
				<td>
					第${page }页/共${pagesize }页&nbsp;&nbsp;
					<a href="javascript:fun(1)">首页</a>&nbsp;
					<a href="javascript:fun(${page-1==0?1:page-1 })">上一页</a>&nbsp;
					<a href="javascript:fun(${page+1>=pagesize?pagesize:page+1})">下一页</a>&nbsp;
					<a href="javascript:fun(${pagesize })">尾页</a>
				</td>
			</tr>
		</table>
	
</center>

<script type="text/javascript">
	function fun(page){
		document.getElementById("page").value=page;
		document.myform.submit();

	}
</script>

</body>
</html>