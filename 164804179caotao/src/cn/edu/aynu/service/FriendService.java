package cn.edu.aynu.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.aynu.dao.FriendDAO;
import cn.edu.aynu.javabean.Friend;

public class FriendService {
	FriendDAO friendDAO = new FriendDAO();
	/*
	 * �����ϵ��
	 */
	public void add(Friend form,int userId) throws SQLException{
		friendDAO.add(form,userId);
	}
	/*
	 * ɾ����ϵ��
	 */
	public void delete(int id) throws SQLException{
		friendDAO.delete(id);
	}
	/*
	 * �޸���ϵ��
	 */
	public void update(Friend form,int id) throws SQLException{
		friendDAO.update(form, id);
	}
	/*
	 * ��ѯ��ϵ��
	 */
	public List<Friend> find(int userId) throws SQLException{
		return friendDAO.findAll(userId);
	}
	public Friend findById(int id) throws SQLException{
		return friendDAO.findById(id);
	}
}









