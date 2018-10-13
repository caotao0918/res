package cn.edu.aynu.service;

import java.sql.SQLException;

import cn.edu.aynu.dao.UserDAO;
import cn.edu.aynu.javabean.User;

public class UserService {
	private UserDAO userDAO = new UserDAO(); 
	/*
	 * 注册
	 */
	public void regist(User user)throws UserException, SQLException{
		User _user = userDAO.findByUserName(user.getUsername());
		if(_user != null){
			throw new UserException("用户名"+user.getUsername()+"已经被注册过了，请重新输入用户名！");
		}else{
			userDAO.addUser(user);
		}
	}
	/*
	 * 登录
	 */
	public User login(User form) throws SQLException, UserException {
		User user = userDAO.findByUserName(form.getUsername());
		if(user == null) 
			throw new UserException("用户名不存在！请重新输入！");
		if(!form.getPassword().equals(user.getPassword()))
			throw new UserException("密码错误，请重新输入！");
		
		return user;
	}
}
