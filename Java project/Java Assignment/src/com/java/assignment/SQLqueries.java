package com.java.assignment;
import java.sql.*;

public class SQLqueries 
{

	private DBConnect databaseConnection;
	private ResultSet result;
	private Statement statement;
	private String query;

	public SQLqueries(String query)
	{
		databaseConnection = new DBConnect();
		this.query = query;
	}
	
	public void executeQuery()
	{
		try
		{
			statement = databaseConnection.getConnect().createStatement();
			result = statement.executeQuery(query);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	public void displayQuery()
	{
		try
		{
			while(result.next())
			{
				System.out.print(result.getString("NAME")+ "\t"+"\t");
				System.out.print(result.getString("LOCATION")+ "\t"+"\t"+"\t"+"\t");
				System.out.println(result.getString("AREAOFCITY")+ "\t"+"\t"+"\t"+"\t");
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
