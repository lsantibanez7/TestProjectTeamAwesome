package com.proj2.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SimpleConnectionPool implements ConnectionPool{
	
	//private static final Logger logger = LogManager.getLogger(SimpleConnectionPool.class); 
	
	private static ConnectionPool mInstance; 
	private static final int INITIAL_POOL_SIZE = 25; 
	private final List<Connection> connections = new ArrayList<>(); 
	private final List<Connection> usedConnections = new ArrayList<>(INITIAL_POOL_SIZE); 
	
	public static ConnectionPool getInstance() {
		if(mInstance == null) {
			mInstance = (ConnectionPool)new SimpleConnectionPool(); 
		}
		return mInstance; 
	}
	
	private SimpleConnectionPool() {
		super(); 
 		final Properties props = getConnectionProperties(); 
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			try {
				Class.forName("oracle.jdbc.OracleDriver"); 
				connections.add(DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"))); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Properties getConnectionProperties() {
		Properties properties = new Properties(); 
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf.properties"));
		} catch(IOException e) {
			e.printStackTrace(); 
			throw new RuntimeException(e); 
		}
		return properties; 
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean releaseConnection(Connection connection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
