<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>登录</title>
<style type="text/css">
	body{
		text-align:center;
		font-size:38px;
	}
	*{
		font-family:华文楷体;
		font-size:18px;
	}
	   h1{
       text-align: center;
       font-size:38px;
   }
</style>
</head>
<body>
	<h1>个人通信录</h1>
	<p style="color:red">${msg }</p>
	<form action="<c:url value='/LoginServlet'/>" method="post">
        用户名:<input type="text" name="username" value="${user.username }"/><br/>
        密 &nbsp;码:<input type="password" name="password" value="${user.password }"/><br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="取消"/>
    <a href="<c:url value='/regist.jsp'/>" target="body" >注册</a>
  </form>
</body>
</html>