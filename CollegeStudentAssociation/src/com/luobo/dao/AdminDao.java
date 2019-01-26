package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.luobo.model.Admin;

public class AdminDao extends BaseDao {
	/*����Ա��¼*/
	public Admin login(Admin admin){
		Admin adminRst = null;
		String sql="select * from s_admin where name=? and password=?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);//��sql��䴫�����ݿ�
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
			pre = con.prepareStatement(sql);//��sql��䴫�����ݿ�
			pre.setInt(1,admin.getId());
			pre.setString(2,admin.getPassword());
			ResultSet executeQuery = pre.executeQuery();
			if(!executeQuery.next()){
				String reString="ԭ�������";
				return reString;
			}
			id=executeQuery.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str= "�޸�ʧ��";
		String sqlString="update s_admin set password=? where id= ?";
		try {
			pre = con.prepareStatement(sqlString);
			pre.setString(1,newPassword);
			pre.setInt(2,id);
			int ser=pre.executeUpdate();
			if(ser>0){
				String reStrin = "�޸ĳɹ�";
				return reStrin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��sql��䴫�����ݿ�
		return str;
	}
}
