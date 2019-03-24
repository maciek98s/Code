package com.java.assignment;

import java.sql.*;

public class DBConnect 
{
	private Connection connect;
	
	public DBConnect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			setConnect(DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mac","mac"));
		}
		catch(Exception ex)
		{
			System.out.println("Error "+ex);
		}
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
}
