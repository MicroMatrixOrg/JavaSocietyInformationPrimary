package com.luobo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_society?useUnicode=true&characterEncoding=utf8";//���ݿ��ַ
	private String dbUsername="root";//�û���
	private String dbPassword="0615";//����
	private String jdbcName="com.mysql.jdbc.Driver";//��������
	
	/**
	 * ��ȡ���ݿ�����
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
	 * �ر����ݿ�����
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
			System.out.println("���ݿ����ӳɹ�");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
