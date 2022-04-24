package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {

	public static void main(String[] args) {
		
		int id;
		String name;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter id");
		id=sc.nextInt();
		
		// Make a connection with Database
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3307/myproject";//myproject is database name
		String un="root";
		String pswd="root";

		try {
			//load the driver
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, un, pswd);
			Statement st=conn.createStatement();
			
			String ins="insert into login1 values("+id+",'"+name+"')";
			int i=st.executeUpdate(ins);
			
			if(i>0) {
				System.out.println("Record Inserted");
			}else {
				System.out.println("Record Not Inserted");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}
