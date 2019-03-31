package com.java.assignment;
import java.sql.*;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


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
			setResult(statement.executeQuery(query));

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
			while(getResult().next())
			{
				System.out.print(getResult().getString("NAME")+ "\t"+"\t");
				System.out.print(getResult().getString("LOCATION")+ "\t"+"\t"+"\t"+"\t");
				System.out.println(getResult().getString("AREAOFCITY")+ "\t"+"\t"+"\t"+"\t");
			}
		}
		catch(Exception e)
		{
			
		}
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}
	/*
	public TableModel displayResultToJtable()
	{
		try
		{
			ResultSetMetaData metaData = result.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            Vector rows = new Vector();

            while (result.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(result.getObject(i));
                }

                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
		}
            catch(Exception ee)
            {
            	return null;
            }

            
	}
	*/
}
	
	

