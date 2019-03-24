package com.java.assignment;

import java.sql.*;

public class DBConnect 
{
	private Connection connect;
	private Statement statement;
	private ResultSet result;
	
	public DBConnect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mac","mac");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PARKS_IN_GALWAY_CITY");
			while(rs.next())
			{
				System.out.println(rs.getString("NUMBER"));
			}
			System.out.println("Connection successfull");
		}
		catch(Exception ex)
		{
			System.out.println("Error "+ex);
		}
	}
}
