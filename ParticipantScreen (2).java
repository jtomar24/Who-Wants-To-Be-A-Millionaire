package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ParticipantScreen extends JFrame implements ActionListener {
	Font f1=new Font("Dialog",Font.ITALIC,30);
	Font f2=new Font("Dialog",Font.ITALIC,35);
	Color c1=new Color(57,255,20);
	Color c2=new Color(40,20,36);
	Color c3=new Color(255,0,0);
	JButton save=new JButton ("save");

	JLabel lbTitle = new JLabel("Participant Entry");
	JLabel lbid = new JLabel("Id: ");
	JTextField txtid = new JTextField(40);
	JLabel lbName = new JLabel("Name: ");
	JTextField txtName = new JTextField(40);
	JLabel lbCity = new JLabel("City: ");
	JTextField txtCity = new JTextField(40);
	
	 ImageIcon img = new ImageIcon("E:/QuizProject/back.jpg");
	 JLabel back = new JLabel();

		
	
	JButton b1 = new JButton(new ImageIcon("C:/Users/juhit/Downloads/next.jpg"));
	JPanel p1 = new JPanel();
	
	Font fo1=new Font("Dialog",Font.BOLD,14);
	Font foTitle=new Font("Dialog",Font.BOLD,16);

	
	public ParticipantScreen() {
		setContentPane(new JLabel(new ImageIcon("C:/Users/juhit/Downloads/back.jpg")));
		setTitle("Who wants to be a Millionaire");
		setSize(1400,700);
		setVisible(true);
		setLayout(null);
		//lbLogo.setBounds(500,100,300,168);
		lbTitle.setBounds(500,100,270,100);
		lbTitle.setFont(f2);
		lbTitle.setForeground(c1);
	//	add(lbLogo);
		add(lbTitle);
		lbid.setBounds(450,220,270,100);
		lbid.setFont(f1);
		lbid.setForeground(c1);
		add(lbid);
		
		txtid.setBounds(570,250,270,40);
		txtid.setFont(f1);
		add(txtid);
		
		
		lbName.setBounds(450,300,270,100);
		lbName.setFont(f1);
		lbName.setForeground(c1);
		add(lbName);
		
		txtName.setBounds(570,330,270,40);
		txtName.setFont(f1);
		add(txtName);
		
		
		lbCity.setBounds(450,380,270,100);
		lbCity.setFont(f1);
		lbCity.setForeground(c1);
		add(lbCity);
		
		txtCity.setBounds(570,410,270,40);
		txtCity.setFont(f1);
		add(txtCity);
		
		//b1.setBounds(1000,600,100,32);
		//add(b1);
		b1.addActionListener(this);
	
		save.setBounds(600,550,100,40);
		add(save);
		save.addActionListener(this);
		save.setFont(f1);
		save.setForeground(c1);
	    save.setBackground(Color.BLACK);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		ParticipantScreen f = new ParticipantScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Participant p = new Participant(txtName.getText(), txtCity.getText());
		ko f = new ko(p);
		this.setVisible(false);
	
		if(e.getSource()==save) {	
			try {
				Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		JOptionPane.showMessageDialog(this, "details saved in database");

PreparedStatement pstmt = con.prepareStatement("insert into contestants values(?,?,?)");
pstmt.setString(1, txtid.getText());
pstmt.setString(2,txtName.getText() );
pstmt.setString(3,txtCity.getText() );
int nr = pstmt.executeUpdate();
pstmt.close();
con.close();
this.setVisible(false);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}