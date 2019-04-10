/*Author : Maciej Skrzypczynski
 *Last Update Date: 09/04/2019
 *
 *Desciption : Class used for getting a connection to the database using oracle driver 
 *also contains methods to create and close connections 
 * 
 */

package com.java.assignment;

import java.sql.*;

public class DBConnect 
{
	//Attributes
	private Connection connect;
	
	public DBConnect()
	{

	}
	//Connect to database
	public boolean Connect()
	{
		try
		{
			/* conneting to redwood in dit 
			 *  String servername = "redwood.ict.ad.dit.ie";
    		String portnumber = "1521";
    		String sid = "pdb12c.ict.ad.dit.ie";
    		String url = "jdbc:oracle:thin:@" + servername + ":" + portnumber + "/" + sid;
    		setConnect(DriverManager.getConnection(url,"mskrzypczynski","C17339163"));
			 	*/
			//connecting to local server
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
	//close Database connection
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

	//getters and setters 
	
	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

}
