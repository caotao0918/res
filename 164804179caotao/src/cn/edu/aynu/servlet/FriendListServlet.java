package cn.edu.aynu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.aynu.javabean.Friend;
import cn.edu.aynu.service.FriendService;
import cn.edu.aynu.service.UserService;

public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int userId;
	Friend friend = new Friend();
	UserService service = new UserService();
	FriendService friendService = new FriendService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		userId = (int)session.getAttribute("userId");
		try {
			List<Friend> friendList = friendService.find(userId);
			request.setAttribute("friendList", friendList);
			request.getRequestDispatcher("/friendList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
