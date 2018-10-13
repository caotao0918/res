<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>注册</title>
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
    <form action="<c:url value='/RegistServlet'/>" method="post"> 
        用户名:<input type="text" name="username" value="${user.username }"/>${errors.username }<br/>
        密 &nbsp;码:<input type="password" name="password" value="${user.password }"/>${errors.password }<br/>
    <input type="submit" value="注册">
    </form>
</body>
</html>