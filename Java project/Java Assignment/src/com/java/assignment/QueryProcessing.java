/*Author : Maciej Skrzypczynski
 *Last Update Date: 09/04/2019
 *
 *Description : A class manipulating and dealing with sql quarries
 *using java sql package 
 *
 *Some of the code used in this classed is sources from the rs2xml.jar file  from the net.proteanit.sql package from the DbUntils.class 
 *the  public static TableModel resultSetToTableModel(ResultSet rs) method
 *the jar file is included with the class files
 * 
 */

package com.java.assignment;
import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class QueryProcessing 
{
	//Attributes
	private DBConnect databaseConnection;
	private ResultSet result;
	private Statement statement;
	private boolean connectionStatus;
	private boolean queryStatus;


	public QueryProcessing()
	{
		//initialsing DBConnect class and connecting to the database
		databaseConnection = new DBConnect();
		connectionStatus = databaseConnection.Connect();
	}
	
	//Execute Query
	public void executeQuery(String query)
	{
		try
		{
			statement = databaseConnection.getConnect().createStatement();
			setResult(statement.executeQuery(query));
			setQueryStatus(true);
		}
		catch(Exception e)
		{
			setQueryStatus(false);
			
		}
	}
	//Get Connection Status 
	public boolean connectionStatus()
	{
		return connectionStatus;
	}
	
	//Close connection to database
	public void closeConnection()
	{
		try
		{
			statement.close();
			databaseConnection.closeConnection();
			connectionStatus = false ;
		}
		catch(Exception e)
		{
			System.out.println("Could not close");
		}
		
	}
	//Put ResultSet into a table model  ###THIS CODE IS NOT MINE IT IS USED FROM THE rs2xml.jar FILE INCLUDED like stated above####
	public  TableModel queryToTableModel() {
		try 
		{
		    ResultSetMetaData metaData = result.getMetaData();
		    int numberOfColumns = metaData.getColumnCount();
		    Vector<String> columnNames = new Vector<String>();

		    // Get the column names
		    for (int column = 0; column < numberOfColumns; column++)
		    {
			columnNames.addElement(metaData.getColumnLabel(column + 1));
		    }

		    // Get all rows.
		    Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
		    
			while (result.next()) 
			{
				Vector<Object> newRow = new Vector<Object>();
				for (int i = 1; i <= numberOfColumns; i++)
				{
					newRow.addElement(result.getObject(i));
				}
		
				rows.addElement(newRow);
			}
		    

		    return new DefaultTableModel(rows, columnNames);
		} catch (Exception e)
		{
		    System.out.println("Could not enter the data into the table");

		    return null;
		}
	}

	//Getters and Setters 
	
	public boolean isQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(boolean queryStatus) {
		this.queryStatus = queryStatus;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}
}
	
	

