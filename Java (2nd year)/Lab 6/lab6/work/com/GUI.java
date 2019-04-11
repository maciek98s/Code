package lab6.work.com;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	private JButton button1;
	private JButton button2;
	private JTextField field1;
	private JLabel label1;
	private int number;
	private int text;
	private int guesscounter;
	private int counter;
	private int textcounter;
	
	public GUI (String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		button1 = new JButton("Generate random number");
		button2 = new JButton("Check your guess");
		field1 = new JTextField("Enter your guess");
		label1 = new JLabel("Then make a gues ....");
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.NORTH);
		add(panel3,BorderLayout.NORTH);
		
		panel1.add(button1);
		panel2.add(label1);
		panel2.add(field1);
		panel3.add(button2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		field1.addActionListener(this);
		
		
		setLocation(100,100);
		setSize(400,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Random randomNumber = new Random();
		if(e.getSource() == button1)
		{
			guesscounter = 0 ;
			counter +=1;
			number = randomNumber.nextInt(100);
			System.out.println(number);
		}

		
		if(e.getSource() == button2)
		{	
			if(counter != 0)
			{
				textcounter +=1;
				try 
				{
					text = Integer.parseInt(field1.getText());
					if(textcounter==0)
					{
						JOptionPane.showMessageDialog(this,"Pelease make a guess first");
					}
					else if(text == number)
					{
						guesscounter +=1;
						JOptionPane.showMessageDialog(this,"Welldone,You took"+guesscounter+" Guesses");
					}
					else if(text < number)
					{
						JOptionPane.showMessageDialog(this,"Number too Low,Guess Again");
						guesscounter +=1;
					}
					else if(text > number)
					{
						JOptionPane.showMessageDialog(this,"Number too High,Guess Again");
						guesscounter +=1;
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(this,"Invalid Input");
					//System.exit(0);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Generate Number First!!!!!");
			}
			
		}
		
	}
	

}
