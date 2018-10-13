package cn.edu.aynu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.aynu.javabean.User;
import cn.edu.aynu.utils.jdbcUtils;

public class UserDAO {
	private  QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
	public void addUser(User form) throws SQLException{
		String sql = "insert into user(username,password) values(?,?)";
		Object[] params = {form.getUsername(),form.getPassword()};
		qr.update(sql, params);
	}

    public User findByUserName(String username) throws SQLException{
        String sql = "select * from user where username=?";
        Object[] params = {username};
        User u = qr.query(sql, new BeanHandler<User>(User.class), params);
        if(u == null){
        	return null;
        }else{
        	return u;
        }
    }

}