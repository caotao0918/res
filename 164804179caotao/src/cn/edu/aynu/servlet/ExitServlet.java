package cn.edu.aynu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.removeAttribute("sessionUser");
		response.getWriter().print("即将退出！谢谢使用！");
		response.setHeader("Refresh", "2;url=http://127.0.0.1:80/164804179caotao/login.jsp");
	}

}
