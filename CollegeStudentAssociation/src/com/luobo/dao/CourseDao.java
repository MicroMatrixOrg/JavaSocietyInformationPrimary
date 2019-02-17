package com.luobo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luobo.model.Course;
import com.luobo.model.Manager;
import com.luobo.util.StringUtils;

public class CourseDao extends BaseDao {
	public boolean addCourse(Course course) {
		String sql = "insert into s_courses (id,name,teacher_id,department_id,max_user,selected_man,info,date)values (null,?,?,?,?,0,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, course.getName());
			pre.setInt(2, course.getTeacher_id());
			pre.setInt(3, course.getDepartment_id());
			pre.setInt(4, course.getMax_user());
			// pre.setInt(5, course.getSelected_man());
			pre.setString(5, course.getInfo());
			pre.setString(6, course.getDate());
			if (pre.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Course> getCourseList(Course course){
		List<Course> courseList = new ArrayList<Course>();
		StringBuffer sql=new StringBuffer("select * from s_courses ");
		if(!StringUtils.isEmpty(course.getName())){
			sql.append(" and name like '%"+course.getName()+"%'");
		}
		if(course.getTeacher_id()!=0){
			sql.append(" and teacher_id = "+ course.getTeacher_id());
		}
		if(course.getDepartment_id()!=0){
			sql.append(" and department_id = "+course.getDepartment_id());
		}
		try {
			PreparedStatement pre= con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = pre.executeQuery();
			while(executeQuery.next()){
				Course cou = new Course();
				cou.setId(executeQuery.getInt("id"));
				cou.setName(executeQuery.getString("name"));
				cou.setTeacher_id(executeQuery.getInt("teacher_id"));
				cou.setDepartment_id(executeQuery.getInt("department_id"));
				cou.setMax_user(executeQuery.getInt("max_user"));
				cou.setSelected_man(executeQuery.getInt("selected_man"));
				cou.setInfo(executeQuery.getString("info"));
				cou.setDate(executeQuery.getString("date"));
				courseList.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	public boolean changeCourse(Course cou){
		String sql = "update s_courses set name = ?,teacher_id = ?,department_id = ?,max_user = ?,info=? ,date = ? where id = ?";
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setString(1,cou.getName());
			pre.setInt(2, cou.getTeacher_id());
			pre.setInt(3, cou.getDepartment_id());
			pre.setInt(4, cou.getMax_user());
			pre.setString(5, cou.getInfo());
			pre.setString(6,cou.getDate());
			pre.setInt(7, cou.getId());
			if(pre.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deleteCourse(int id){
		String sql = "delete from s_courses where id = ?";
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
	public boolean selectEnable(int course_id){
		String sql = "select * from s_courses where id = ?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, course_id);
			ResultSet executeQuery = pre.executeQuery();
			if(executeQuery.next()){
				int max_user = executeQuery.getInt("max_user");
				int selected_man = executeQuery.getInt("selected_man");
				if(selected_man>max_user) return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	public boolean updateSelectNum(int course_id,int num){
		String sql = "update s_courses set selected_man = selected_man + ? where id=?";
		if(num<0){
			sql = "update s_courses set selected_man = selected_man + ? where id=?";
		}
		try {
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1,num);
			pre.setInt(2,course_id);
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
