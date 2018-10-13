package cn.edu.aynu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.aynu.javabean.User;
import cn.edu.aynu.service.UserException;
import cn.edu.aynu.service.UserService;
import cn.edu.aynu.utils.CommonsUtils;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		UserService userService = new UserService();
		User form = CommonsUtils.toBean(request.getParameterMap(), User.class);
		Map<String,String> errors = new HashMap<String,String>();
		//���û���������֤
		String username = form.getUsername();
		if(username == null || username.trim().isEmpty()){
			errors.put("username", "�û�������Ϊ�գ�");
		}else if(username.length() < 2 || username.length() > 10){
			errors.put("username", "�û�������ֻ����2-10֮�䣡");
		}
		//�����������֤
		String password = form.getPassword();
		if(password == null || password.trim().isEmpty()){
			errors.put("password", "���벻��Ϊ�գ�");
		}else if(password.length() < 6 || password.length() > 12){
			errors.put("password", "���볤��ֻ����6-12֮�䣡");
		}
		//�Դ�����д���
		if(errors.size() > 0){
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		} 
		try {
			userService.regist(form);
			response.getWriter().print("ע��ɹ������������¼���棡");
			response.setHeader("Refresh","2;url=http://127.0.0.1:80/164804179caotao/login.jsp");
		} catch (UserException | SQLException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}  
	}

}
