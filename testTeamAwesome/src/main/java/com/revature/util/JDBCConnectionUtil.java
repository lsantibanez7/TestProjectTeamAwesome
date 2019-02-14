package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
	//final static Logger log = Logger.getLogger(JDBCConnectionUtil.class);
	
	static { 
		try {
	//		log.info("JDBC Driver is initialized");
			Class.forName("oracle.jdbc.OracleDriver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} 
		String url = "jdbc:oracle:thin:@db-instance-id-james-roberts-test-1.cthz5uw88e2d.us-east-2.rds.amazonaws.com:1521:ORCL"; 
		String username = "jimroberts10"; 
		String password = "p4ssw0rd"; 
		return DriverManager.getConnection(url, username, password); 
	}

}
