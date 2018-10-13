<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
  <style type="text/css">
    body{
        text-align: center;
        font-size:38px;
    }
         *{
           font-family:华文楷体;
           font-size:18px;
           color:#F0F";
   }
 </style>
</head>
<body>
	<h1 style="font-size:38px;text-align: center;">欢迎${username }登录到通信录系统</h1>
    <a  style="font-size:26px;" href="<c:url value='/FriendListServlet?id=${id }'/>">查看联系人</a>
    <a  style="font-size:26px;" href="<c:url value='/addFriend.jsp'/>">添加联系人</a>
    <a  style="font-size:26px;" href="<c:url value='/ExitServlet'/>">退出系统</a>
    <table border="1" align="center" width="60%">
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>地址</th>
            <th>操作1</th>
            <th>操作2</th>
        </tr>
    </table>
</body>
</html>