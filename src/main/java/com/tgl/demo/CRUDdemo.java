package com.tgl.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CRUDdemo {

	public static void main(String[] args) {
		
		CRUDdemo demoObject = new CRUDdemo();
//		demoObject.createData();
//		demoObject.updateData();
//		demoObject.deleteData();
		demoObject.readData();

	}
	
	public void createData() {
		
		DB_Connection DBConnectionObject = new DB_Connection();
		Connection connection = DBConnectionObject.get_connection();
		PreparedStatement preparedstatement = null;
		
		java.util.Date date = new java.util.Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		java.text.SimpleDateFormat SDF = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			String create = "INSERT INTO staffTable (staffHeight, staffWeight, "
					+ "staffEnglishName, staffChineseName, "
					+ "staffExt, staffEmail, staffBMI, "
					+ "createDateTime, updateDateTime)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			
			preparedstatement = connection.prepareStatement(create);
			preparedstatement.setInt(1, 1);
			preparedstatement.setInt(2, 1);
			preparedstatement.setString(3, "a");
			preparedstatement.setString(4, "a");
			preparedstatement.setString(5, "a");
			preparedstatement.setString(6, "a");
			preparedstatement.setDouble(7, 1.00d);
			preparedstatement.setString(8, SDF.format(date));
			preparedstatement.setString(9, SDF.format(timestamp));
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readData() {
		
		DB_Connection DBConnectionObject = new DB_Connection();
		Connection connection = DBConnectionObject.get_connection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			
			String read = "SELECT * FROM staffTable WHERE staffID=?";
			preparedstatement = connection.prepareStatement(read);
			preparedstatement.setInt(1, 1);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				System.out.println(resultset.getString("staffID") + "\t");
				System.out.println(resultset.getString("staffHeight") + "\t");
				System.out.println(resultset.getString("staffWeight") + "\t");
				System.out.println(resultset.getString("staffEnglishName") + "\t");
				System.out.println(resultset.getString("staffChineseName") + "\t");
				System.out.println(resultset.getString("staffExt") + "\t");
				System.out.println(resultset.getString("staffEmail") + "\t");
				System.out.println(resultset.getString("staffBMI") + "\t");
				System.out.println(resultset.getString("createDateTime") + "\t");
				System.out.println(resultset.getString("updateDateTime") + "\t");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateData() {
		
		DB_Connection DBConnectionObject = new DB_Connection();
		Connection connection = DBConnectionObject.get_connection();
		PreparedStatement preparedstatement = null;
		
		java.util.Date date = new java.util.Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		java.text.SimpleDateFormat SDF = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			String update = "UPDATE staffTable SET staffHeight=?, staffWeight=?, "
					+ "staffEnglishName=?, staffChineseName=?, "
					+ "staffExt=?, staffEmail=?, staffBMI=?, "
					+ "updateDateTime=? "
					+ " WHERE staffID=?";
			preparedstatement = connection.prepareStatement(update);
			preparedstatement.setInt(1, 2);
			preparedstatement.setInt(2, 2);
			preparedstatement.setString(3, "b");
			preparedstatement.setString(4, "b");
			preparedstatement.setString(5, "b");
			preparedstatement.setString(6, "b");
			preparedstatement.setDouble(7, 1.00d);
			preparedstatement.setString(8, SDF.format(timestamp));
			preparedstatement.setInt(9, 57);
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteData() {
		
		DB_Connection DBConnectionObject = new DB_Connection();
		Connection connection = DBConnectionObject.get_connection();
		PreparedStatement preparedstatement = null;
		
		try {
			String delete = "DELETE FROM staffTable WHERE staffID=?";
			preparedstatement = connection.prepareStatement(delete);
			preparedstatement.setInt(1, 57);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
