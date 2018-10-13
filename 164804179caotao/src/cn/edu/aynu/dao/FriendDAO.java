package cn.edu.aynu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.aynu.javabean.Friend;
import cn.edu.aynu.utils.jdbcUtils;

public class FriendDAO {
	private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
	/*
	 * ���
	 */
	public void add(Friend form,int userId) throws SQLException{
		String sql = "insert into friend(name,tel,addr,userId) values(?,?,?,?)";
		Object[] params = {form.getName(),form.getTel(),form.getAddr(),userId};
		qr.update(sql, params);
	}
	/*
	 * ɾ��
	 */
	public void delete(int id) throws SQLException{
		String sql = "delete from friend where id=?";
		qr.update(sql, id);
	}
	/*
	 * �޸�
	 */
	public void update(Friend form,int id) throws SQLException{
		String sql = "update friend set name=?,tel=?,addr=? where id=?";
		Object[] params = {form.getName(),form.getTel(),form.getAddr(),id};
		qr.update(sql, params);
	}
	/*
	 * ��ѯ
	 */

	public List<Friend> findAll(int userId) throws SQLException {
		String sql = "select * from friend where userId = ?";
		List<Friend> friendList = qr.query(sql,new BeanListHandler<Friend>(Friend.class),userId);
		return friendList;
	}
	/*
	 * ��ѯһ����
	 */
	public Friend findById(int id) throws SQLException{
		String sql = "select * from friend where id=?";
		Object[] params = {id};
		Friend friend =  (Friend) qr.query(sql, new BeanHandler<Friend>(Friend.class), params);
		return friend;
	}
	
}

