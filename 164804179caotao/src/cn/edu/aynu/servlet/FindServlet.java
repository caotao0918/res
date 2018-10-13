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

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendService friendService = new FriendService();
		String ids = request.getParameter("id");
		int id = Integer.valueOf(ids);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		System.out.println(id);
		try {
			Friend friend = friendService.findById(id);
			request.setAttribute("fri", friend);
			request.getRequestDispatcher("/alter.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
