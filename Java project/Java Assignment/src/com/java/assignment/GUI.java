/*Author : Maciej Skrzypczynski
 *Last Update Date: 11/04/2019
 *
 *Desciption : A class that contains The gui of the programm. 
 *It contains methods that execute code depending on which button is pressed
 *and it also contains methods that manipulate  the GUI and also it contains error checking methods 
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
	private JButton connectButton;
	private JButton advanceModeButton;
	private JButton sqlModeButton;
	private JButton infoButton;
	private JButton submitButton;
	private JButton normalModeButton;
	private JButton quitButton;
	private JButton previewButton;
	
	private JTextField selectTextfield;
	private JTextField clauseTextfield1;
	private JTextField clauseTextfield2;
	private JTextField clauseTextfield3;
	
	private JLabel comboBoxLabel;
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel westPanel;
	
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dataModel;
	private JComboBox box;
	private QueryProcessing datasetQuery;
	
	public GUI(String title)
	{
		super(title);
		//setting layout
		setLayout(new BorderLayout());
		//Creating a string array for Combo Box
		String[] facts = {"Interesting fact 1","Interesting fact 2","Interesting fact 3","Interesting fact 4"};
		
		//Initializing Attributes 
		box = new JComboBox(facts);
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		westPanel = new JPanel();
		
		comboBoxLabel = new JLabel();
		
		connectButton = new JButton("Connect");
		advanceModeButton = new JButton("AdvancedMode");
		sqlModeButton = new JButton("SQL MODE");
		infoButton = new JButton("INFO");
		submitButton = new JButton("Submit");
		normalModeButton = new JButton("NormalMode");
		quitButton = new JButton("Quit");
		previewButton = new JButton("Preview");
		
		selectTextfield = new JTextField("Enter Category");
		clauseTextfield1 = new JTextField("",5);
		clauseTextfield2 = new JTextField("",5);
		clauseTextfield3 = new JTextField("",5);
		
		//add panel to layout
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(westPanel, BorderLayout.WEST);
		
		//adding components to northPanel
		northPanel.add(connectButton);
		
		//adding listeners to Components of GUI
		connectButton.addActionListener(this);
		advanceModeButton.addActionListener(this);
		sqlModeButton.addActionListener(this);
		infoButton.addActionListener(this);
		submitButton.addActionListener(this);
		normalModeButton.addActionListener(this);
		quitButton.addActionListener(this);
		previewButton.addActionListener(this);
		box.addActionListener(this);
		
		
		//full screen 
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    if 	(e.getSource() == connectButton)
	    {
	    	try
	    	{
	    		//if "Enter Category" is in selectTextfield  means connectButton == connect Button so do the following
	    		if(selectTextfield.getText().equals("Enter Category"))
	    		{
		    		datasetQuery = new QueryProcessing();
		    		//if connection == false meaning connection unsuccessfull
		    		if(datasetQuery.connectionStatus()==false)
		    		{
		    			JOptionPane.showMessageDialog(null, "Could not successfully connect to the database");
		    			System.exit(0);
		    			
		    		}
		    		//else successfull
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null, "Welcome to the Data Explorer program");
		    			northPanel.add(advanceModeButton);
		    			northPanel.add(sqlModeButton);
		    			northPanel.add(normalModeButton);
		    			northPanel.remove(connectButton);
		    			northPanel.add(quitButton);
		    		}
		    		normalModeOn();
	    		}
	    		// else if selectTextfield is not equal to "Enter Category" the coonectButton button is reused for submit button for sql mode
	    		else
	    		{
	    			clearTable();
	    			datasetQuery.executeQuery(selectTextfield.getText());
	    			errorMessageCheck();
	    			displayTable();
	    		}
	    	}
	    	catch(Exception ee)
	    	{
	    		
	    	}
	    	
	    }
	    //When advanceModeButton is pressed Panel clears and goes into Advance mode method 
	    if (e.getSource() == advanceModeButton)
	    {
	    	clearMode();
	    	advanceModeOn();
	    	JOptionPane.showMessageDialog(null, "Welcome to the Advnaced mode please click the INFO button for more information about this mode");
	    }
	  //When sqlModeButton is pressed Panel clears and goes into sql mode method 
	    if (e.getSource() == sqlModeButton)
	    {
			clearMode();
			sqlModeOn();
			JOptionPane.showMessageDialog(null, "Welcome to SQL Mode in this mode you can enter an sql select statement of your choice with correct syntax to be viewed in the table (The Table name is city)");
		
	    }
	    //When infoButton clicked display information in a form of a pop up
	    if (e.getSource() == infoButton)
	    {
	    	JOptionPane.showMessageDialog(null, "The Advanced mode lets you specify which perticular category you would like to view and allows you for an OPTIONAL clause "
	    	+ " \n for example one could enter (Number  name = Corrib Park) to view the numberid of parks which the name Corrib Park or just name with the rest of the fields blank"
	    	+ "\n to just view the name collumn, Click PREVIEW button to Show the whole table and remeber when searching for a specific name SPELLING AND CAPITOL latters matter ");
	    	
	    	
		
	    }
	    //Initialising what pops up when the user interacts with the Combo Box 
	    if (e.getSource() == box)
	    {
	    	//temporary string 
	    	String message = (String) box.getSelectedItem();
	    	switch(message)
	    	{
	    		case "Interesting fact 1":
	    		{
	    			comboBoxLabel.setText("Names of the parks that are located in Barna Road, Galway ");
	    			datasetQuery.executeQuery("select \"NAME\",\"LOCATION\" from city where \"LOCATION\" = 'Renmore, Galway'");
	    			clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 2":
	    		{
	    			comboBoxLabel.setText("Names and locations of Parks in Galway City ");
	    			datasetQuery.executeQuery("select \"NAME\",\"LOCATION\" from city");
	    			clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 3":
	    		{
	    			comboBoxLabel.setText("Names of the Parks in galway city and their facilities ");
	    			datasetQuery.executeQuery("select \"NAME\",\"FACILITIES\" from city");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 4":
	    		{
	    			comboBoxLabel.setText("Parks that are only city parks");
	    			datasetQuery.executeQuery("select \"NAME\",\"DESCR\" from city where \"DESCR\" = 'City Park'");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    	
	    	}
	    }
	    //button when pressed manipulates Jtextfields to execute a query
	    if (e.getSource() == submitButton)
	    {
	    	//string variables to store getTextField values
	    	String qeuryString1,qeuryString2,qeuryString3,qeuryString4; 
	    	clearTable();
	    	qeuryString1  = "\""+ selectTextfield.getText().toUpperCase()+"\"";
	    	
	    	//if not where clause 
	    	 if(clauseTextfield1.getText().equals(""))
	    	 {
	    		 datasetQuery.executeQuery("select "+qeuryString1+"from city");
	    		 errorMessageCheck();
	    	 }
	    	 //else if there is where clause 
	    	 else
	    	 {
	    		 qeuryString2  = "\""+ clauseTextfield1.getText().toUpperCase()+"\"";
	    		 qeuryString3  = clauseTextfield2.getText().toUpperCase();
	    		 qeuryString4  = "'"+ clauseTextfield3.getText()+"'";
	    		 datasetQuery.executeQuery("select "+qeuryString1+"from city where "+qeuryString2+qeuryString3+qeuryString4);
	    		 errorMessageCheck();
	    	 }
	    	displayTable();
	    }
	    //when normalModeButton  pressed calls normalmode method
	    if (e.getSource() == normalModeButton)
	    {
	    	clearMode();
	    	normalModeOn();
	    	
	    }
	    //quitButton when pressed closes connection and exits the program
	    if (e.getSource() == quitButton)
	    {
	    	datasetQuery.closeConnection();
	    	System.exit(0);
	    	
	    }
	    //previewButton when pressed shows all entries in the table 
	    if (e.getSource() == previewButton)
	    {
	    	clearTable();
	    	datasetQuery.executeQuery("Select * from city");
	    	errorMessageCheck();
	    	displayTable();
	    	
	    	
	    }
		
	}
	//Method to turn on Normal mode by manipulating westpanel and its components 
	private void normalModeOn()
	{
		clearTable();
		comboBoxLabel.setText("Interesting facts");
		westPanel.add(comboBoxLabel);
		westPanel.add(box);
		revalidate();
		JOptionPane.showMessageDialog(null, "Welcome to the Normalmode please use the combo box on the left to pick an interesting fact to display in the table, this is also the default mode"
				+ "you should note if you want more options please consider changing modes ");
	}
	//method to clear west panel 
	private void clearMode()
	{
		westPanel.removeAll();
		revalidate();
	}
	//Method to turn on Advance mode by manipulating westpanel and its components 
	private void advanceModeOn()
	{
		clearTable();
		//re-initializing west panel
		westPanel.add(infoButton);
		selectTextfield.setText("Enter your Category");
		westPanel.add(selectTextfield);
		westPanel.add(clauseTextfield1);
		westPanel.add(clauseTextfield2);
		westPanel.add(clauseTextfield3);
		westPanel.add(submitButton);
		westPanel.add(previewButton);
		revalidate();
	}
	//Method to display table in the GUI
	private void displayTable()
	{
		try
		{
	    	
			dataModel = (DefaultTableModel) (datasetQuery.queryToTableModel());
	    	table = new JTable();
			table.setModel(dataModel);
	   		scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(800,400));
			centerPanel.add(scrollPane);
			revalidate();
		}
		catch(Exception e)
		{
			System.out.println("Table is null");
		}
	}
	//method to clear the center panel that contains the table(scroll panel) 
	private void clearTable()
	{
    	centerPanel.removeAll();
    	revalidate();
    	repaint();
		
	}
	//Method to turn on SQL mode by manipulating west panel and its components 
	private void sqlModeOn()
	{
		clearTable();
		selectTextfield.setText("Enter your SQL Statement here");
		connectButton = new JButton("Submit");
		connectButton.addActionListener(this);
		westPanel.add(selectTextfield);
		westPanel.add(connectButton);
		revalidate();
		
	}
	//Method to check if query executed successfully and if not display appropriate message
	private void errorMessageCheck()
	{
		if(datasetQuery.isQueryStatus() ==false)
		{
			JOptionPane.showMessageDialog(null, "Oops seems like an error has occured , please make sure your input is correct");
		}
	}

	
}
