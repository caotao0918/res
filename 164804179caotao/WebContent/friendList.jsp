<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好友列表</title>
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
   h1{
       text-align: center;
        font-size:38px;
   }
   a:link{
        color: #999;
        text-decoration: none;
   }
   a:VISITED {
    text-decoration: none;
    color: #c60;
}
    a:HOVER {
    text-decoration: none;
    color: #00F;
}
    </style>
</head>
<body>
	<h1>欢迎${username }登录到通信录系统</h1>
    <a  style="font-size:26px;" href="<c:url value='/FriendListServlet?userId=${userId }'/>">查看联系人</a>
    <a  style="font-size:26px;" href="<c:url value='/addFriend.jsp'/>">添加联系人</a>
    <a  style="font-size:26px;" href="<c:url value='ExitServlet'/>">退出系统</a>
    <table border="1" align="center" width="60%">
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>地址</th>
            <th>操作1</th>
            <th>操作2</th>
        </tr>
        <c:forEach items="${friendList }" var="list">
        <tr>
            <td>${list.name }</td>
            <td>${list.tel }</td>
            <td>${list.addr }</td>
            <td><a href="<c:url value='/FindServlet?id=${list.id }'/>">修改</a>
            </td>
            <td>
                <a href="<c:url value='/DeleteServlet?id=${list.id }'/>" >删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>