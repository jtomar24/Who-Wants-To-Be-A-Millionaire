package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ThankUScreen extends JFrame  {

	
	 ImageIcon img = new ImageIcon("C:/Users/juhit/Downloads/ty.jpg");
	 JLabel back = new JLabel();
     JLabel milli = new JLabel(new ImageIcon("E:/QuizProject/milli1.jpg"));

	 JLabel name = new JLabel();
	

	
	public ThankUScreen(String nm) {
		setTitle("Who wants to be a Millionaire");	
		setSize(1400,800);
		setVisible(true);
		
		add("South",name);

		name.setBounds(450,550,1000,100);
		name.setText(" Thank You For participating "+nm);
		name.setFont(new Font("Dialog", Font.BOLD, 24));
		name.setForeground(Color.yellow);
		
		milli.setBounds(450, 100,500,410);
		
		add(milli);
	
		add(name);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(-7,0);
		back = new JLabel(" ",img,JLabel.CENTER);
		back.setBounds(0,0,1400,800);
		add(back);
	}
	
	

	

}