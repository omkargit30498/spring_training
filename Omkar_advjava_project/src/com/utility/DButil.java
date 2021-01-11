package com.utility;

import java.sql.*;

public class DButil {
	public static Connection getmysqldbConnection() {
		String driverClassname="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java_training";
		String dbusername="root";
		String dbpassword="root";
		Connection con=null;
		
		try {
			Class.forName(driverClassname);
			con=DriverManager.getConnection(url, dbusername,dbpassword);
		}catch (Exception e) {
			System.out.println("Error occured"+e);
		}
		return con;
	}

}
