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
import cn.edu.aynu.utils.CommonsUtils;

public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int userId;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		FriendService friendService = new FriendService();
		HttpSession session = request.getSession();
		userId = (int) session.getAttribute("userId");
		Friend form = CommonsUtils.toBean(request.getParameterMap(), Friend.class);
		try {
			friendService.add(form,userId);
			request.getRequestDispatcher("/FriendListServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
