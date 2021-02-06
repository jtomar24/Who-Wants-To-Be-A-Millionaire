package quiz;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeScreen extends JFrame implements ActionListener {

	
	Font fTittle = new Font("Dialog",Font.ROMAN_BASELINE,50);
	
  	  JButton b1 = new JButton(new ImageIcon("C:/Users/juhit/Downloads/1start.jpg"));
	    JLabel back = new JLabel();
	   
	public WelcomeScreen()
	{
		
		setContentPane(new JLabel(new ImageIcon("C:/Users/juhit/Downloads/clg2.jpg")));
	
		setTitle("Who wants to be a Millionaire");
		setSize(1400,800);
		setVisible(true);
		setLayout(null);
		
	
	
		
		b1.setBounds(1000, 570,100,53);

	        add(b1);
	    b1.addActionListener(this);
 
		        
	    
	}
	public static void main(String[] args) 
	{
		WelcomeScreen f = new WelcomeScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ParticipantScreen f = new ParticipantScreen();
		this.setVisible(false);
		
	
	}

}

