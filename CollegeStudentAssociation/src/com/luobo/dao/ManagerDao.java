package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import com.luobo.model.Admin;
import com.luobo.model.Manager;
import com.luobo.util.StringUtils;

public class ManagerDao extends BaseDao {
	public Manager login(Manager managera){
		Manager managerRst = null;
		String sql="select * from s_manager where name=? and password=?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);//把sql语句传给数据库
			pre.setString(1,managera.getName());
			pre.setString(2,managera.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(executeQuery.next()){
				managerRst = new Manager();
				managerRst.setId(executeQuery.getInt("id"));
				managerRst.setName(executeQuery.getString("name"));
				managerRst.setPassword(executeQuery.getString("password"));
				managerRst.setTitle(executeQuery.getString("title"));	
				managerRst.setContact_infomation(executeQuery.getString("contact_infomation"));
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
		return managerRst;
	}
	public boolean addManager(Manager manager){
		String sql = "insert into s_manager values(null,?,?,?,?)";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,manager.getName());
			pre.setString(2,manager.getPassword());
			pre.setString(3,manager.getTitle());
			pre.setString(4, manager.getContact_infomation());
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Manager> getManagerList(Manager manager){
		List<Manager> managerList = new ArrayList<Manager>();
		String sql = "select * from s_manager";
		if(!StringUtils.isEmpty(manager.getName())){
			sql += " where name like '%"+manager.getName()+"%'";
		}
		try {
			PreparedStatement pre= con.prepareStatement(sql);
			ResultSet executeQuery = pre.executeQuery();
			while(executeQuery.next()){
				Manager ma = new Manager();
				ma.setId(executeQuery.getInt("id"));
				ma.setName(executeQuery.getString("name"));
				ma.setPassword(executeQuery.getString("password"));
				ma.setTitle(executeQuery.getString("title"));
				ma.setContact_infomation(executeQuery.getString("contact_infomation"));
				managerList.add(ma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managerList;
	}
	
	public boolean changeManager(Manager man){
		String sql = "update s_manager set name = ?,password = ?,title = ?,contact_infomation = ? where id = ?";
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setString(1,man.getName());
			pre.setString(2, man.getPassword());
			pre.setString(3, man.getTitle());
			pre.setString(4, man.getContact_infomation());
			pre.setInt(5, man.getId());
			if(pre.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deleteManager(int id){
		String sql = "delete from s_manager where id = ?";
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, id);
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 public String  updateManagerPassword(Manager manager,String newPassword){
		 String sql = "select * from s_manager where id =? and password =?";
		 PreparedStatement pre = null;
		 int id = 0;
		 try {
			pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, manager.getId());
			pre.setString(2, manager.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(!executeQuery.next()){
				String res ="旧密码输入错误";
				return res;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String rest = "密码更新失败";
		 String sqlString = "update s_teacher set password =? where id = ?";
		 try {
			pre = (PreparedStatement)con.prepareStatement(sqlString);
			pre.setString(1, newPassword);
			pre.setInt(2, id);
			int index =pre.executeUpdate(); 
			if(index>0){
				String tes = "更新密码成功";
				return tes;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return rest;
	 }
}
