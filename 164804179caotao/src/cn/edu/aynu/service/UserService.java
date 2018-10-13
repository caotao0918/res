package cn.edu.aynu.service;

import java.sql.SQLException;

import cn.edu.aynu.dao.UserDAO;
import cn.edu.aynu.javabean.User;

public class UserService {
	private UserDAO userDAO = new UserDAO(); 
	/*
	 * ע��
	 */
	public void regist(User user)throws UserException, SQLException{
		User _user = userDAO.findByUserName(user.getUsername());
		if(_user != null){
			throw new UserException("�û���"+user.getUsername()+"�Ѿ���ע����ˣ������������û�����");
		}else{
			userDAO.addUser(user);
		}
	}
	/*
	 * ��¼
	 */
	public User login(User form) throws SQLException, UserException {
		User user = userDAO.findByUserName(form.getUsername());
		if(user == null) 
			throw new UserException("�û��������ڣ����������룡");
		if(!form.getPassword().equals(user.getPassword()))
			throw new UserException("����������������룡");
		
		return user;
	}
}
