<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改页面</title>
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
    </style>
</head>
<body>
	<h1>修改联系人信息</h1>
    <form action="<c:url value='/AlterServlet'/>">
        <table border="1" width="35%" align="center">
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="name" value="${fri.name }"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td>
                    <input type="text" name="tel" value="${fri.tel }"/>
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input type="text" name="addr" value="${fri.addr }"/>
                </td>
            </tr>        
        </table>
        <input style="margin-right:30px;" type="submit" value="更改"/>
        <a href="/164804179caotao/FriendListServlet">取消</a>
       </form> 
</body>
</html>