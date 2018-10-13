package cn.edu.aynu.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.aynu.dao.FriendDAO;
import cn.edu.aynu.javabean.Friend;

public class FriendService {
	FriendDAO friendDAO = new FriendDAO();
	/*
	 * 添加联系人
	 */
	public void add(Friend form,int userId) throws SQLException{
		friendDAO.add(form,userId);
	}
	/*
	 * 删除联系人
	 */
	public void delete(int id) throws SQLException{
		friendDAO.delete(id);
	}
	/*
	 * 修改联系人
	 */
	public void update(Friend form,int id) throws SQLException{
		friendDAO.update(form, id);
	}
	/*
	 * 查询联系人
	 */
	public List<Friend> find(int userId) throws SQLException{
		return friendDAO.findAll(userId);
	}
	public Friend findById(int id) throws SQLException{
		return friendDAO.findById(id);
	}
}









