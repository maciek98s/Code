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
	private JTextField textfield1;
	private JPanel panel1;
	private JPanel panel2;
	private JTable table;
	private DefaultTableModel model;
	
	public GUI(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		panel1 = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton("Submit");
		textfield1 = new JTextField("Enter query here");
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		panel1.add(textfield1);
		panel1.add(button1);
		button1.addActionListener(this);
		
		
		setSize(400,400);
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
	    		SQLqueries sql = new SQLqueries(textfield1.getText());
		    	sql.executeQuery();
		    	sql.displayQuery();
	    		//DefaultTableModel def = (DefaultTableModel) sql.displayResultToJtable();
	    		//JTable table = (JTable) sql.displayResultToJtable();
		    	table = new JTable();
	    		table.setModel(DbUtils.resultSetToTableModel(sql.getResult()));

	    		JScrollPane pane = new JScrollPane(table);
	    		panel2.remove(pane);
	    		panel2.add(pane);
		    	
	    	}
	    	catch(Exception ee)
	    	{
	    		
	    	}
	    	
	    }
		
	}

	
}
