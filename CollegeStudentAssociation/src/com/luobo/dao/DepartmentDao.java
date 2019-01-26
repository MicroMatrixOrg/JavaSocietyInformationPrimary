package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.luobo.model.Department;
import com.luobo.util.StringUtils;
import com.luobo.util.TimeSet;
import com.mysql.jdbc.ResultSet;

public class DepartmentDao extends BaseDao{
	public boolean addDepartment(Department dp){
		String sql = "insert into s_departmentinfo (id,name,createday,master,contact,modification_time,info)values (null,?,?,?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, dp.getName());
			pre.setString(2, dp.getCreateday());
			pre.setInt(3, dp.getMasterId());
			pre.setString(4,dp.getContact());
			pre.setTimestamp(5, Timestamp.valueOf(TimeSet.currentDate()));
			pre.setString(6, dp.getInfo());
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Department> getDepartmentList(Department departmentList){
		List<Department> retDepartmentList = new ArrayList<Department>();
		StringBuffer sql = new StringBuffer("select * from s_departmentinfo ");
		if(!StringUtils.isEmpty(departmentList.getName())){
			sql.append("where name like '%"+departmentList.getName()+"%'");
		}
		if(departmentList.getId()!=0){
			sql.append("where master = '%"+departmentList.getMasterId()+"%'");
		}
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			java.sql.ResultSet executeQuery = pre.executeQuery();
			while(executeQuery.next()){
				Department dep = new Department();
				dep.setId(executeQuery.getInt("id"));
				dep.setName(executeQuery.getString("name"));
				dep.setCreateday(executeQuery.getString("createday"));
				dep.setMasterId(executeQuery.getInt("master"));
				dep.setContact(executeQuery.getString("contact"));
				dep.setModificationTime(executeQuery.getTimestamp("modification_time"));
				dep.setInfo(executeQuery.getString("info"));
				retDepartmentList.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retDepartmentList;
	}
	public boolean deleteDepartment(int id){
		String sql = "delete from s_departmentinfo where id =?";
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
	public boolean editDepartment(Department dep){
		String sql = "update s_departmentinfo set name=?,master=?,contact=?,info=?,createday=?,modification_time=? where id = ?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, dep.getName());
			pre.setInt(2,dep.getMasterId());
			pre.setString(3, dep.getContact());
			pre.setString(4, dep.getInfo());
			pre.setString(5, dep.getCreateday());
			pre.setTimestamp(6, Timestamp.valueOf(TimeSet.currentDate()));
			pre.setInt(7, dep.getId());
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
}
