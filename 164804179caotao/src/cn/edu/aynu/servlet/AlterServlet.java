package cn.edu.aynu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.aynu.javabean.Friend;
import cn.edu.aynu.service.FriendService;
import cn.edu.aynu.service.UserService;
import cn.edu.aynu.utils.CommonsUtils;

public class AlterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Friend friend = new Friend();
	UserService service = new UserService();
	FriendService friendService = new FriendService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		System.out.println(id);
		Friend form = CommonsUtils.toBean(request.getParameterMap(), Friend.class);
		try {
			friendService.update(form,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/FriendListServlet").forward(request, response);
	}

}
