package com.tgl.demo;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.io.BufferedWriter;
//import java.io.FileWriter;

public class JavaWork2 {

	public static List<Staff> staffArrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		BufferedReader readFile = null;
//		BufferedWriter writeFile = null;
		
		Connection connection = null;
		
//		read file
		try {
			
			DB_Connection objDBConnection=new DB_Connection();
			connection=objDBConnection.get_connection();
			
			final PreparedStatement preparedstatement = connection.prepareStatement(
					 "INSERT INTO staffTable (staffHeight, staffWeight, "
					 + "staffEnglishName, staffChineseName, "
					 + "staffExt, staffEmail, staffBMI, "
					 + "createDateTime, updateDateTime)"
					 + " VALUES (?,?,?,?,?,?,?,?,?)");
			
			readFile = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("D:\\list")
						)
					);
			String text;
			
			java.util.Date date = new java.util.Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			java.text.SimpleDateFormat SDF = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
//			create staff table
			try {
				while (((text = readFile.readLine()) != null)) {
					String[] alreadySplit = splitList(text);
					staffArrayList.add(new Staff(alreadySplit[0],
							alreadySplit[1],
							alreadySplit[2],
							alreadySplit[3],
							alreadySplit[4],
							alreadySplit[5],
							String.valueOf(calculateBMI(alreadySplit[0], alreadySplit[1]))
							));
				}
				
				for (Staff staff : staffArrayList) {
					preparedstatement.setInt(1, Integer.valueOf(staff.getStaffHeight()));
					preparedstatement.setInt(2, Integer.valueOf(staff.getStaffWeight()));
					preparedstatement.setString(3, staff.getStaffEnglishName());
					preparedstatement.setString(4, staff.getStaffChineseNmae());
					preparedstatement.setString(5, staff.getStaffExt());
					preparedstatement.setString(6, staff.getStaffEmail());
					preparedstatement.setDouble(7, Double.valueOf(staff.getStaffBMI()));
					preparedstatement.setString(8, SDF.format(date));
					preparedstatement.setString(9, SDF.format(timestamp));
					preparedstatement.execute();
				}
				
//				writeFile = new BufferedWriter(
//						new FileWriter("D:\\relist.txt")
//						);
//				for (Staff staff : staffArrayList) {
//					writeFile.write(staff + "\r\n");
//				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
//			for (Staff staff : staffArrayList) {
//				System.out.println(staff);
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				readFile.close();
//				writeFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
//	split list
	public static String[] splitList(String text) {
		
		String[] words = text.split("\\s+");

		return words;
	}
	
//	calculate BMI
	public static float calculateBMI(String height, String weight) {
		
		float BMI;
		int H = Integer.parseInt(height);
		int W = Integer.parseInt(weight);
		BMI = W / (((float)H/100)*((float)H/100));
		
		return (float)(Math.round(BMI*100))/100;
	}
	
}