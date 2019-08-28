package com.tgl.demo;

import java.sql.*;

public class DB_Connection {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.67.67.186:3306/emp_yori?characterEncoding=utf8";
	
	static final String USER = "root";
	static final String PASS = "123456";

	public static void main(String[] args) {
		  DB_Connection objDBConnection=new DB_Connection();
		  System.out.println(objDBConnection.get_connection());
	}
	
	public Connection get_connection() {
		 Connection connection=null;
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");              
		  connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
//			do something
		} 
		  return connection;
	}

}
