package com.java.assignment;

import java.sql.*;

public class DBConnect 
{
	private Connection connect;
	
	public DBConnect()
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
