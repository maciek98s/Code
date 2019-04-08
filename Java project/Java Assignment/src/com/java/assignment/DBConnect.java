package com.java.assignment;

import java.sql.*;

public class DBConnect 
{
	private Connection connect;
	
	public DBConnect()
	{

	}
	public boolean Connect()
	{
		try
		{
			/*  String servername = "ferdia.cs.dit.ie";
    String portnumber = "1521";
    String sid = "ORA11GDB";
    String url = "jdbc:oracle:thin:@" + servername + ":" + portnumber + ":" + sid;
    String user, pass;
	user = readEntry("userid  : ");
	pass = readEntry("password: ");
	*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			setConnect(DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mac","mac"));
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("ERROR");
			return false;
		}
	}
	public void closeConnection()
	{
		try
		{
			connect.close();
		}
		catch(Exception e)
		{
			
		}
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

}
