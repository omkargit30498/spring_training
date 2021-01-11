package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.cj.protocol.Resultset;
import com.utility.DButil;

public class LoginRepository {

	public boolean finduser(String username) {
		Connection con=DButil.getmysqldbConnection();
		String sql="select * from login where username=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String password=rs.getString("password");
				System.out.println(password);
				return true;
				
			}else {
				System.out.println("user not found");
			}
				
		}catch (Exception e) {
			System.out.println("error"+e);
		}
		return false;
	}
}
