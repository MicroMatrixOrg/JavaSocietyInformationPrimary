package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.luobo.model.Department;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;
import com.luobo.util.TimeSet;

public class MembersDao extends BaseDao{
	
	public boolean addMembers(Members members){
		String sql = "insert into s_members (id,name,sex,age,department_id,contact,password)values (null,?,?,?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, members.getName());
			pre.setString(2, members.getSex());
			pre.setInt(3, members.getAge());
			pre.setInt(4, members.getDepartment_id());
			pre.setString(5, members.getContact());
			pre.setString(6, members.getPassword());
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Members> getMembersList(Members members){
		List<Members> retList = new ArrayList<Members>();
		StringBuffer sql=new StringBuffer("select * from s_members ");
		if(!StringUtils.isEmpty(members.getName())){
			sql.append("and name like '%"+members.getName()+"%'");
		}
		if(members.getDepartment_id()!=0){
			sql.append("and  department_id = "+members.getDepartment_id());
		}
		try {
			PreparedStatement pre = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = pre.executeQuery();
			while(executeQuery.next()){
				Members me = new Members();
				me.setId(executeQuery.getInt("id"));
				me.setName(executeQuery.getString("name"));
				me.setSex(executeQuery.getString("sex"));
				me.setAge(executeQuery.getInt("age"));
				me.setContact(executeQuery.getString("contact"));
				me.setDepartment_id(executeQuery.getInt("department_id"));
				me.setPassword(executeQuery.getString("password"));
				retList.add(me);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean deleteMembers(int id){
		String sql = "delete from s_members where id = ?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
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
	
	public boolean changeMembers(Members members){
		String sql = "update s_members set name= ? ,sex = ?, age = ? ,password = ?,department_id = ?,contact= ? where id=?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, members.getName());
			pre.setString(2, members.getSex());
			pre.setInt(3, members.getAge());
			pre.setString(4, members.getPassword());
			pre.setInt(5, members.getDepartment_id());
			pre.setString(6, members.getContact());
			pre.setInt(7, members.getId());
			if(pre.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String updateMembersPassword(Members mem,String newpassword){
		String sql = "select * from s_members where id = ? and password = ?";
		PreparedStatement pre = null;
		int id=0;
		try {
			pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, mem.getId());
			pre.setString(2, mem.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(!executeQuery.next()){
				String res = "Ô­ÃÜÂë´íÎó";
				return res;
			}
			id = executeQuery.getInt("id");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String rest = "ÐÞ¸ÄÊ§°Ü";
		String sqlString = "update s_members set password = ? where id = ?";
		try {
			pre = (PreparedStatement)con.prepareStatement(sqlString);
			pre.setString(1, newpassword);
			pre.setInt(2, id);
			int exeInd = pre.executeUpdate();
			if(exeInd>0){
				String restring = "ÐÞ¸Ä³É¹¦";
				return restring;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;
	} 
	public Members login(Members memb){
		Members members=null;
		String sql = "select * from s_members where name =? and password =?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, memb.getName());
			pre.setString(2, memb.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			
			if(executeQuery.next()){
				members = new Members();
				members.setId(executeQuery.getInt("id"));
				members.setName(executeQuery.getString("name"));
				members.setSex(executeQuery.getString("sex"));
				members.setDepartment_id(executeQuery.getInt("department_id"));
				members.setAge(executeQuery.getInt("age"));
				members.setContact(executeQuery.getString("contact"));
				members.setPassword(executeQuery.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
}
