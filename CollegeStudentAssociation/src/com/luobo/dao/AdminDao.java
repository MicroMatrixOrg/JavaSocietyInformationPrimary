package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.luobo.model.Admin;

public class AdminDao extends BaseDao {
	/*管理员登录*/
	public Admin login(Admin admin){
		Admin adminRst = null;
		String sql="select * from s_admin where name=? and password=?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);//把sql语句传给数据库
			pre.setString(1,admin.getName());
			pre.setString(2,admin.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(executeQuery.next()){
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}
	
	public String changePassword(Admin admin , String newPassword){
		String sql="select * from s_admin where id=? and password=?";
		PreparedStatement pre=null;
		int id=0;
		try {
			pre = con.prepareStatement(sql);//把sql语句传给数据库
			pre.setInt(1,admin.getId());
			pre.setString(2,admin.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(!executeQuery.next()){
				String reString="原密码错误";
				return reString;
			}
			id=executeQuery.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str= "修改失败";
		String sqlString="update s_admin set password=? where id= ?";
		try {
			pre = con.prepareStatement(sqlString);
			pre.setString(1,newPassword);
			pre.setInt(2,id);
			int ser=pre.executeUpdate();
			if(ser>0){
				String reStrin = "修改成功";
				return reStrin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库
		return str;
	}
}
