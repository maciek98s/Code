package com.work.lab;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessing 
{
	;
	int i = 0;
	File file;
	Scanner myScanner;
	String filename;

	public FileProcessing(String filenme)
	{
		this.filename = filenme;
	}
	public void openFile()
	{
		
		try
		{
			file = new File(filename);
			myScanner = new Scanner(file);
		}
		catch(Exception e)
		{
			System.out.println("File dosnt exist");
		}
	}
	
	public void ReadFile()
	{
		try
		{
			while(myScanner.hasNextLine())
			{
				System.out.print(myScanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("Please enter a file or Open file first");
		}
		
	}
	
	
	public boolean ValidateString(String role)
	{
		boolean Valid = false;
		String testing[] = new String[5];
		int i = 0;
		try
		{
			while(myScanner.hasNextLine())
			{
				testing[i] = myScanner.next();
				i += 1;
			}
			
			for(i=0;i<5;i++)
			{
				testing[i] = testing[i].replace(",","");
				
				if(role.equals(testing[i]))
				{
					Valid = true;
				}
			}
			if(Valid == false)
			{
				System.out.println("Invalid Role");
			}	
			
			return Valid;
		}
		catch(Exception e)
		{
			System.out.println("Please enter a file or Open file first to use validation method");
			return Valid;
		}
	}
	
	public void closeFile()
	{
		try
		{
			myScanner.close();
		}
		catch(Exception e)
		{
			System.out.println("Please enter a file or Open file first to close file");
		}
	}
	public String writeTofile(String name)
	{
		try
		{
			file = new File(filename);
			PrintWriter myOutFile = new PrintWriter(file);
			myOutFile.println(name);
			myOutFile.close();
			return "File has be written to ";
		}
		catch(Exception e)
		{
			return "File has not been written to ";
		}
	}
	
	
}