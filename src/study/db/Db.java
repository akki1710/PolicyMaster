package study.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	
	public static Connection myGetConnection() throws SQLException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jdbc_url = "jdbc:mysql://localhost/db";
		Connection con = DriverManager.getConnection(jdbc_url,"root","akki");
		return con;
		
		
		
	}

}
