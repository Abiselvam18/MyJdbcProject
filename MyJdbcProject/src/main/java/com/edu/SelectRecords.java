package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecords {

	public static void main(String[] args) {
		//Connection 
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3307/myproject";
				String un="root";
				String pass="root";
				Connection conn=null;
				Statement st=null;
				ResultSet rs=null;
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url,un,pass);
					st=conn.createStatement();
					
					String sql="select * from student";
					rs=st.executeQuery(sql);
					System.out.println("sid\tsname\tsemail\t\tdept");
					while(rs.next()) {
						int id=rs.getInt(1);
						String n=rs.getString(2);
						String e=rs.getString(3);
						String d=rs.getString(4);
					System.out.println(id+"\t"+n+"\t"+e+"\t"+d);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
}

