package com.java.assignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
	private JButton button1;
	private JTextField textfield1;
	private JPanel panel1;
	
	public GUI(String title)
	{
		super(title);
		setLayout(new FlowLayout());
		panel1 = new JPanel(new FlowLayout());
		button1 = new JButton("Submit");
		textfield1 = new JTextField("Enter query here");
		
		panel1.add(textfield1);
		panel1.add(button1);
		button1.addActionListener(this);
		
		add(panel1);
		
		setSize(400,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    if 	(e.getSource() == button1)
	    {
	    	SQLqueries sql = new SQLqueries(textfield1.getText());
	    	sql.executeQuery();
	    	sql.displayQuery();
	     	
	    }
		
	}
	
}
