/*Author : Maciej Skrzypczynski
 *Last Update Date: 09/04/2019
 *
 *Desciption : A class that contains The gui of the programm. 
 *It contains methods that execute code depending on which button is pressed
 *and it also contains methods that manipulate with the GUI and error checking methods 
 * 
 */

package com.java.assignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
	//Attributes
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	
	private JLabel label1;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane pane;
	private DefaultTableModel dataModel;
	private JComboBox box;
	private QueryProcessing datasetQuery;
	
	public GUI(String title)
	{
		super(title);
		//setting layour
		setLayout(new BorderLayout());
		//Creating an array for Combo Box
		String[] facts = {"Interesting fact 1","Interesting fact 2","Interesting fact 3","Interesting fact 4"};
		
		//Initialising Attributes 
		box = new JComboBox(facts);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		label1 = new JLabel();
		
		button1 = new JButton("Connect");
		button2 = new JButton("AdvancedMode");
		button3 = new JButton("SQL MODE");
		button4 = new JButton("INFO");
		button5 = new JButton("Submit");
		button6 = new JButton("NormalMode");
		button7 = new JButton("Quit");
		button8 = new JButton("Preview");
		
		textfield1 = new JTextField("Enter Category");
		textfield2 = new JTextField("",5);
		textfield3 = new JTextField("",5);
		textfield4 = new JTextField("",5);
		//add panel to layout
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.WEST);
		
		//adding components to panel
		panel1.add(button1);
		
		//adding listeners to Componenets of GUI
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		box.addActionListener(this);
		
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	    if 	(e.getSource() == button1)
	    {
	    	try
	    	{
	    		//if button pressed for the first time as connect button  do this 
	    		if(textfield1.getText().equals("Enter Category"))
	    		{
		    		datasetQuery = new QueryProcessing();
		    		if(datasetQuery.connectionStatus()==false)
		    		{
		    			JOptionPane.showMessageDialog(null, "Could not successfully connect to the database");
		    			System.exit(0);
		    			
		    		}
		    		//if connection == true meaning successful set up the panel
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null, "Welcome to the Data Explorer program");
		    			panel1.add(button2);
		    			panel1.add(button3);
		    			panel1.add(button6);
		    			panel1.remove(button1);
		    			panel1.add(button7);
		    		}
		    		normalmodeON();
	    		}
	    		// else reused for submit button for sql mode
	    		else
	    		{
	    			clearTable();
	    			datasetQuery.executeQuery(textfield1.getText());
	    			errorMessageCheck();
	    			displayTable();
	    		}
	    			


	    	}
	    	catch(Exception ee)
	    	{
	    		
	    	}
	    	
	    }
	    //When button2 to pressed Panel clears and goes into Advance mode method 
	    if (e.getSource() == button2)
	    {
	    	clearMode();
	    	advancemodeON();
	    	JOptionPane.showMessageDialog(null, "Welcome to the Advnaced mode please click the INFO button for more information about this mode");
	    }
	  //When button2 to pressed Panel clears and goes into sql mode method 
	    if (e.getSource() == button3)
	    {
			clearMode();
			sqlMode();
			JOptionPane.showMessageDialog(null, "Welcome to SQL Mode in this mode you can enter an sql select statement of your choice with correct syntax to be viewed in the table (The Table name is city)");
		
	    }
	    //When button4 clicked display information in a form of a pop up
	    if (e.getSource() == button4)
	    {
	    	JOptionPane.showMessageDialog(null, "The Advanced mode lets you specify which perticular category you would like to view and allows you for an OPTIONAL clause ");
	    	JOptionPane.showMessageDialog(null, "for example one could enter (Number  name = Corrib Park) to view the numberid of parks which the name Corrib Park or just name with the rest of the fields blank");
	    	JOptionPane.showMessageDialog(null, "to just view the name collumn, Click PREVIEW button to Show the whole table and remeber when searching for a specific name SPELLING AND CAPITOL latters matter ");
	    	
	    	
		
	    }
	    //Initilising what pops up when the user interacts with the Combo Box 
	    if (e.getSource() == box)
	    {
	    	//temporary string 
	    	String message = (String) box.getSelectedItem();
	    	switch(message)
	    	{
	    		case "Interesting fact 1":
	    		{
	    			label1.setText("Names of the parks that are located in Barna Road, Galway ");
	    			datasetQuery.executeQuery("select \"NAME\",\"LOCATION\" from city where \"LOCATION\" = 'Renmore, Galway'");
	    			clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 2":
	    		{
	    			label1.setText("Names and locations of Parks in Galway City ");
	    			datasetQuery.executeQuery("select \"NAME\",\"LOCATION\" from city");
	    			clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 3":
	    		{
	    			label1.setText("Names of the Parks in galway city and their facilities ");
	    			datasetQuery.executeQuery("select \"NAME\",\"FACILITIES\" from city");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 4":
	    		{
	    			label1.setText("Parks that are only city parks");
	    			datasetQuery.executeQuery("select \"NAME\",\"DESCR\" from city where \"DESCR\" = 'City Park'");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    	
	    	}
	    }
	    //button when pressed manipulates Jtextfields to execute a query
	    if (e.getSource() == button5)
	    {
	    	String qeuryString1,qeuryString2,qeuryString3,qeuryString4; 
	    	clearTable();
	    	qeuryString1  = "\""+ textfield1.getText().toUpperCase()+"\"";
	    	 if(textfield2.getText().equals(""))
	    	 {
	    		 datasetQuery.executeQuery("select "+qeuryString1+"from city");
	    		 errorMessageCheck();
	    	 }
	    	 else
	    	 {
	    		 qeuryString2  = "\""+ textfield2.getText().toUpperCase()+"\"";
	    		 qeuryString3  = textfield3.getText().toUpperCase();
	    		 qeuryString4  = "'"+ textfield4.getText()+"'";
	    		 datasetQuery.executeQuery("select "+qeuryString1+"from city where "+qeuryString2+qeuryString3+qeuryString4);
	    		 errorMessageCheck();
	    	 }
	    	//clearTable();
	    	displayTable();
	    }
	    //button when pressed calls normalmode method
	    if (e.getSource() == button6)
	    {
	    	clearMode();
	    	normalmodeON();
	    	
	    }
	    //button when pressed closes connection and exits the program
	    if (e.getSource() == button7)
	    {
	    	datasetQuery.closeConnection();
	    	System.exit(0);
	    	
	    }
	    //button when pressed shows all entries in the table 
	    if (e.getSource() == button8)
	    {
	    	clearTable();
	    	datasetQuery.executeQuery("Select * from city");
	    	errorMessageCheck();
	    	displayTable();
	    	
	    	
	    }
		
	}
	//Method to turn on Normal mode by manipulating panels and their components 
	public void normalmodeON()
	{
		clearTable();
		label1.setText("Interesting facts");
		panel3.add(label1);
		panel3.add(box);
		revalidate();
		JOptionPane.showMessageDialog(null, "Welcome to the Normalmode please use the combo box on the left to pick an interesting fact to display in the table, this is also the default mode"
				+ "you should note if you want more options please consider changing modes ");
	}
	//method to clear panel 3 
	public void clearMode()
	{
		panel3.removeAll();
		revalidate();
	}
	//Method to turn on Advance mode by manipulating panels and their components 
	public void advancemodeON()
	{
		clearTable();
		panel3.add(button4);
		textfield1.setText("Enter your Category");
		panel3.add(textfield1);
		panel3.add(textfield2);
		panel3.add(textfield3);
		panel3.add(textfield4);
		panel3.add(button5);
		panel3.add(button8);
		revalidate();
	}
	//Method to display table in the GUI
	public void displayTable()
	{
		try
		{
	    	
			dataModel = (DefaultTableModel) (datasetQuery.queryToTableModel());
	    	table = new JTable();
			table.setModel(dataModel);
	   		pane = new JScrollPane(table);
			pane.setPreferredSize(new Dimension(800,400));
			panel2.add(pane);
			revalidate();
		}
		catch(Exception e)
		{
			System.out.println("Table is null");
		}
	}
	//method to clear the panel that shows the table 
	public void clearTable()
	{
    	panel2.removeAll();
    	revalidate();
    	repaint();
		
	}
	//Method to turn on SQL mode by manipulating panels and their components 
	public void sqlMode()
	{
		clearTable();
		textfield1.setText("Enter your SQL Statement here");
		button1 = new JButton("Submit");
		button1.addActionListener(this);
		panel3.add(textfield1);
		panel3.add(button1);
		revalidate();
		
	}
	//Method to check if query executed successfully and if not display appropriate message
	public void errorMessageCheck()
	{
		if(datasetQuery.isQueryStatus() ==false)
		{
			JOptionPane.showMessageDialog(null, "Oops seems like an error has occur , please make sure your input is correct");
		}
	}

	
}
