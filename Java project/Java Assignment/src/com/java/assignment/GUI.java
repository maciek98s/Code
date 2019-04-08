package com.java.assignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	
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
	private Queries sql;
	
	public GUI(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		String[] facts = {"Interesting fact 1","Interesting fact 2","Interesting fact 3","Interesting fact 4"};
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
		textfield1 = new JTextField("Enter Category");
		
		textfield2 = new JTextField("",5);
		textfield3 = new JTextField("",5);
		textfield4 = new JTextField("",5);
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.WEST);
		
		panel1.add(button1);
		//panel1.add(button2);
		//panel1.add(button3);
		//panel1.add(button6);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button7.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
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
	    		sql = new Queries();
	    		if(sql.ConnectionStatus()==false)
	    		{
	    			JOptionPane.showMessageDialog(null, "Could not successfully connect to the database");
	    			System.exit(0);
	    			
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Connected");
	    			panel1.add(button2);
	    			panel1.add(button3);
	    			panel1.add(button6);
	    			panel1.remove(button1);
	    			panel1.add(button7);
	    		}
	    		if(textfield1.getText().equals("Enter Category"))
	    		{
		    		sql.executeQuery("Select * from city");
		    		normalmodeON();
	    		}
	    		else
	    		{
	    			clearTable();
	    			sql.executeQuery(textfield1.getText());
	    			displayTable();
	    		}
	    			


	    	}
	    	catch(Exception ee)
	    	{
	    		
	    	}
	    	
	    }
	    if (e.getSource() == button2)
	    {
	    	JOptionPane.showMessageDialog(null, "Welcome to the Advnaced mode please click the INFO button for more information about this mode");
	    	clearMode();
	    	advancemodeON();
	    }
	    if (e.getSource() == button3)
	    {
	    	JOptionPane.showMessageDialog(null, "Welcome to SQL Mode in this mode you can enter an sql select statement of your choice with correct syntax to be viewed in the table");
			clearMode();
			sqlMode();

		
	    }
	    if (e.getSource() == button4)
	    {
	    	JOptionPane.showMessageDialog(null, "The Advanced mode lets you specify which perticular category you would like to view and allows you for an OPTIONAL clause "
	    			+ "for example one could enter (Number  name = Corrib Park) to view the numberid of parks which the name Corrib Park ");
	    	
	    	
		
	    }
	    if (e.getSource() == box)
	    {
	    	String message = (String) box.getSelectedItem();
	    	switch(message)
	    	{
	    		case "Interesting fact 1":
	    		{
	    			label1.setText("Names of the parks that are located in Barna Road, Galway ");
	    			sql.executeQuery("select \"NAME\",\"LOCATION\" from city where \"LOCATION\" = 'Renmore, Galway'");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 2":
	    		{
	    			label1.setText("Names of the parks that are located in Barna Road, Galway ");
	    			sql.executeQuery("select \"NAME\",\"LOCATION\" from city");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 3":
	    		{
	    			label1.setText("Names of the parks that are located in Barna Road, Galway ");
	    			sql.executeQuery("select * from city");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    		case "Interesting fact 4":
	    		{
	    			label1.setText("Names of the parks that are located in Barna Road, Galway ");
	    			sql.executeQuery("select NAME from city where NUMBER='1'");
	    	    	clearTable();
	    	    	displayTable();
	    			break;
	    		}
	    	
	    	}
	    }
	    if (e.getSource() == button5)
	    {
	    	String qeuryString1,qeuryString2,qeuryString3,qeuryString4; 
	    	
	    	qeuryString1  = "\""+ textfield1.getText().toUpperCase()+"\"";
	    	 if(textfield2.getText().equals(""))
	    	 {
	    		 sql.executeQuery("select "+qeuryString1+"from city");
	    	 }
	    	 else
	    	 {
	    		 qeuryString2  = "\""+ textfield2.getText().toUpperCase()+"\"";
	    		 qeuryString3  = textfield3.getText().toUpperCase();
	    		 qeuryString4  = "'"+ textfield4.getText()+"'";
	    		 System.out.println("select "+qeuryString1+"from city where "+qeuryString2+qeuryString3+qeuryString4);
	    		 sql.executeQuery("select "+qeuryString1+"from city where "+qeuryString2+qeuryString3+qeuryString4);
	    	 }
	    	clearTable();
	    	displayTable();
	    }
	    if (e.getSource() == button6)
	    {
	    	clearMode();
	    	normalmodeON();
	    	
	    }
	    if (e.getSource() == button7)
	    {
	    	sql.closeConnection();
	    	System.exit(0);
	    	
	    }
		
	}
	
	public void normalmodeON()
	{
		clearTable();
		displayTable();
		label1.setText("Interesting facts");
		panel3.add(label1);
		panel3.add(box);
		revalidate();
		JOptionPane.showMessageDialog(null, "Welcome to the Normal please use the combo box on the left to pick an interesting fact to display in the table, this is also the default mode"
				+ "you should note if you want more options please consider changing modes ");
	}
	public void clearMode()
	{
		panel3.removeAll();
		revalidate();
	}
	public void advancemodeON()
	{
		panel3.add(button4);
		//textfield1.setText("Enter your Category");
		panel3.add(textfield1);
		panel3.add(textfield2);
		panel3.add(textfield3);
		panel3.add(textfield4);
		panel3.add(button5);
		revalidate();
	}
	public void displayTable()
	{
    	dataModel = (DefaultTableModel) (sql.resultSetToTableModel());
    	table = new JTable();
		table.setModel(dataModel);
   		pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(800,400));
		panel2.add(pane);
		revalidate();
	}
	public void clearTable()
	{
    	panel2.removeAll();
    	revalidate();
    	repaint();
		
	}
	public void sqlMode()
	{
		textfield1.setText("Enter your SQL Statement here");
		button1 = new JButton("Submit");
		button1.addActionListener(this);
		panel3.add(textfield1);
		panel3.add(button1);
		revalidate();
		
	}

	
}
