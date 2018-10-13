package cn.edu.aynu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.aynu.service.FriendService;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		FriendService friendService = new FriendService();
		String ids = request.getParameter("id");
		int id = Integer.valueOf(ids);
		try {
			friendService.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/FriendListServlet").forward(request, response);
	}

}
