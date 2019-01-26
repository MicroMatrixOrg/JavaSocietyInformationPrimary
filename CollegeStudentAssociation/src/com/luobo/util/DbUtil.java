package com.luobo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_society?useUnicode=true&characterEncoding=utf8";//数据库地址
	private String dbUsername="root";//用户名
	private String dbPassword="0615";//密码
	private String jdbcName="com.mysql.jdbc.Driver";//驱动名称
	
	/**
	 * 获取数据库连接
	 * @author
	 * @throws Exception
	 */
	public Connection getCon(){
		try{
			Class.forName(jdbcName);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection con = null;
		try{
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return con;
	}
	/*
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args){
		DbUtil dbUtil=new DbUtil();
		try{
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
