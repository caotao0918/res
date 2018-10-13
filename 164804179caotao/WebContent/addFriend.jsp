<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加好友</title>
</head>
<body>
  <h1 style="font-size:38px;text-align:center">添加新的联系人</h1>
    <form action="<c:url value='/AddFriendServlet?userId=${userId }'/>">
        <table border="1" width="30%" align="center">
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td>
                    <input type="text" name="tel"/>
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input type="text" name="addr"/>
                </td>
            </tr>        
        </table>
        <input style="margin-left:800px;text-align:center" type="submit"  value="添加"/>    
        <a href="/164804179caotao/FriendListServlet">取消</a>        
    </form>
</body>
</html>