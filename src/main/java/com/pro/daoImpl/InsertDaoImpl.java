/**
 * 
 */
package com.pro.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pro.bean.UserBean;
import com.pro.dao.InsertDao;
import com.pro.utility.DbConnecton;

/**
 * @author AR
 *
 */
public class InsertDaoImpl implements InsertDao {
	@Override
	public void insert(UserBean userBean) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into Person(uname,pwd,email,contact,age) values(?,?,?,?,?)";
		con = DbConnecton.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, userBean.getUname());
			ps.setString(2, userBean.getPwd());
			ps.setString(3, userBean.getEmail());
			ps.setString(4, userBean.getContact());
			ps.setInt(5, userBean.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UserBean> getValues() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserBean userBean = null;
		List<UserBean> list = new ArrayList<UserBean>();
		String query = "select * from Person";
		con = DbConnecton.getConnection();
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				userBean = new UserBean();
				userBean.setId(rs.getInt("id"));
				userBean.setUname(rs.getString("uname"));
				userBean.setPwd(rs.getString("pwd"));
				userBean.setEmail(rs.getString("email"));
				userBean.setContact(rs.getString("contact"));
				userBean.setAge(rs.getInt("age"));
				list.add(userBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(UserBean userBean) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DbConnecton.getConnection();
			String sql = "update person set uname=?,pwd=?,email=?,contact=?,age=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userBean.getUname());
			preparedStatement.setString(2, userBean.getPwd());
			preparedStatement.setString(3, userBean.getEmail());
			preparedStatement.setString(4, userBean.getContact());
			preparedStatement.setInt(5, userBean.getAge());
			preparedStatement.setInt(6, userBean.getId());
			preparedStatement.executeUpdate();
			System.out.println(userBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(UserBean userBean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnecton.getConnection();
		try {

			String sql = "delete from person where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userBean.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
