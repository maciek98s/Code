/*
 * Author:Maciej Skrzypczynski
 * Date: 28/03/2019
 * Description: GUI class wich contains the contents of the GUI
 */
package lab8.work.com;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	//Attributes
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextArea area1; 
	//private ArrayList<String> list;
	private ArrayList<Person> list = new ArrayList<Person>();
	private Person person;
	
	//Constructor
	public GUI(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		button1 = new JButton("Save");
		button2 = new JButton("Show all");
		button3 = new JButton("Delete");
		field1 = new JTextField(100);
		field1 = new JTextField("First Name");
		field1.setColumns(10);
		field2 = new JTextField(100);
		field2 = new JTextField("Surname");
		field2.setColumns(10);
		field3 = new JTextField(100);
		field3 = new JTextField("City");
		field3.setColumns(10);
		area1 = new JTextArea("List of people is as follows:\n");
		area1.setRows(10);
		area1.setColumns(45);
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		//Adding the panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
		//Adding attributes to the panel
		panel1.add(field1);
		panel1.add(field2);
		panel1.add(field3);
		panel1.add(button1);
		panel1.add(button2);
		panel2.add(button3);
		panel2.add(area1);
		//Set screen size
		setSize(600,400);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Link the listener to the button you want to monitor
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			person = new Person(field1.getText(),field2.getText(),field3.getText());
			//person.setFirstName(field1.getText());
			//person.setSurname(field2.getText());
			//person.setCity(field3.getText());
			JOptionPane.showMessageDialog(this,"You just added : "+field1.getText()+" "+field2.getText()+" from "+field3.getText()+".");
			list.add(person);
		}
		
		if(event.getSource() == button2)
		{
			for (Person i: list)
			{
				area1.append(i + "\n");
			}
		     
		}
		
		if(event.getSource() == button3)
		{
			list.clear();
			area1.setText(null);
			
		}
	}
}