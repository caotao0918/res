package cn.edu.aynu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.aynu.javabean.User;
import cn.edu.aynu.service.*;
import cn.edu.aynu.utils.CommonsUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		UserService userService = new UserService();
		User form = CommonsUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			HttpSession session = request.getSession();
			session.setAttribute("sessionUser", user);
			session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getUserId());
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
