package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luobo.model.Course;
import com.luobo.model.SelectCourse;
import com.luobo.util.StringUtils;

public class SelectedCourseDao extends BaseDao {
	public boolean addChooser(SelectCourse selectCourse) {
		String sql = "insert into s_selectcourse (id,member_id,course_id,department_id)values (null,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, selectCourse.getMember_id());
			pre.setInt(2, selectCourse.getCourse_id());
			pre.setInt(3, selectCourse.getDepartment_id());
			if (pre.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<SelectCourse> getChooseList(SelectCourse selectCourse){
		List<SelectCourse> selectList = new ArrayList<SelectCourse>();
		String sql="select * from s_selectcourse ";
		if(selectCourse.getMember_id()!=0){
			sql += "where member_id= "+selectCourse.getMember_id();
		}
		try {
			PreparedStatement pre= con.prepareStatement(sql);
			ResultSet executeQuery = pre.executeQuery();
			while(executeQuery.next()){
				SelectCourse cou = new SelectCourse();
				cou.setMember_id(executeQuery.getInt("member_id"));
				cou.setDepartment_id(executeQuery.getInt("department_id"));
				cou.setCourse_id(executeQuery.getInt("course_id"));
				selectList.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectList;
	}
	public boolean changeSelectedCourse(SelectCourse sc){
		String sql = "update s_selectcourse set department_id=?,course_id=? where member_id = ?";
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1,sc.getDepartment_id());
			pre.setInt(2, sc.getCourse_id());
			pre.setInt(3, sc.getMember_id());
			if(pre.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteSelectedCourse(int member_id,int course_id){
		String sql = "delete from s_selectcourse where member_id = ? and course_id = ? ";
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, member_id);
			pre.setInt(2, course_id);
			if(pre.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isSelected(SelectCourse selectCourse){
		String sql = "select * from s_selectcourse where member_id = ? and course_id =?";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, selectCourse.getMember_id());
			pre.setInt(2, selectCourse.getCourse_id());
			ResultSet executeQuery = pre.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
