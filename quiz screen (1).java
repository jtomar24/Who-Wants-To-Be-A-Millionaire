package quiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
//import java.util.Timer;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class ko extends JFrame implements ActionListener {
	Timer	time;
	public int min=0;
	public int min1=0;
	public int sec=0;
	Font f1=new Font("Dialog",Font.ITALIC,20);
	Color c1=new Color(0,0,0);
	Color c2=new Color(245,245,245);
	Color c3=new Color(255,0,0);
	Font f2=new Font("Dialog",Font.ITALIC,40);
	
	JLabel label;
	JLabel t1 = new JLabel("TotalTime:");
	JLabel t2 = new JLabel("10 min");
    JLabel tt = new JLabel("Time Taken:");
	JLabel ss = new JLabel("00 ");
	JLabel mm= new JLabel(" ");
	JLabel mm1= new JLabel("00 ");
	JLabel c= new JLabel(":");
	JLabel da= new JLabel();
    JLabel d = new JLabel("Date:");
	
	int qno=0;
	Color selcol =  new Color(0,162,232);
	JLabel lbQuesno = new JLabel("QNo : "+(qno+1));
	JTextArea txtQues = new JTextArea(20,300);
	JLabel lop1 = new JLabel("A");
	JButton  btnOption1 = new JButton("Option 1 ");
	JLabel lop2 = new JLabel("B");
	JButton  btnOption2 = new JButton("Option 2 ");
	JLabel lop3 = new JLabel("C");
	JButton  btnOption3 = new JButton("Option 3 ");
	JLabel lop4 = new JLabel("D");
	JButton  btnOption4 = new JButton("Option 4 ");
	
	JButton btnLock = new JButton("Lock it...");
	JButton btnNext = new JButton("Next");
	

	 ImageIcon img = new ImageIcon("C:/Users/juhit/Downloads/n.jpg");     //ye dekh ye he background image ke liye 
	 JLabel back = new JLabel();
	 
	 ImageIcon pp1 = new ImageIcon("E:/QuizProject/ppart.jpg");
	 JLabel ppback = new JLabel();
	
	JButton b1 = new JButton("Proceed ");
	JPanel p1 = new JPanel();
	JPanel pques = new JPanel();
	JPanel plife = new JPanel();
	//JPanel ppart = new JPanel();
	
	JSplitPane spright = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pques,plife);
	JSplitPane spmain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,spright);
	Font fo1=new Font("Dialog",Font.BOLD,14);
	Font foTitle=new Font("Dialog",Font.BOLD,16);
	
	JButton btnQuesno[] = new JButton[10];
	String prizes[]= {"1000","5000","10,000","20,000","50,000","1,00,000 ","5,00,000","25,00,000","50,00,000","1,000,000"};
	int width,height;
	JLabel lblLogo = new JLabel(new ImageIcon("C:/Users/juhit/Downloads/log.jfif"));
	
	JButton btnFlip = new JButton(new ImageIcon("C:/Users/juhit/Downloads/btnFlip.jpg"));
	JButton btn50 = new JButton(new ImageIcon("C:/Users/juhit/Downloads/btn50.jpg"));
	JButton btnPhone = new JButton(new ImageIcon("C:/Users/juhit/Downloads/btnphone.jpg"));
	
	Color original;
	Question qu=null;
	
	ArrayList<Question> liques = new ArrayList<>();
	boolean flip=true,phone=true,fifty=true;
	int score=0;
	
	
	JLabel pname = new JLabel ();
	JLabel pcity = new JLabel();
	Participant p = null;
	
	public ko(Participant p) {
		
		label = new JLabel();
		add(label);
	label.setFont(f1);
	label.setForeground(c1);
	label.setBackground(c3);
t1.setBounds(300,3,300, 50);
t1.setFont(f1);
add(t1);
t1.setForeground(c1);
ss.setForeground(c3);
mm.setForeground(c3);
d.setFont(f1);
d.setForeground(c1);
d.setBounds(10, 11,300,30);
add(d);
da.setFont(f1);
da.setForeground(c1);
da.setBounds(70, 2,300,50);
add(da);
t2.setBounds(400,3,300, 50);
t2.setFont(f1);
add(t2);
t2.setForeground(c1);
tt.setBounds(570,2,300, 50);
tt.setFont(f1);
add(tt);
tt.setForeground(c1);
mm.setBounds(670,2,300, 50);
mm1.setForeground(c3);
c.setForeground(c3);
mm1.setBounds(700,2,300, 50);
add(mm1);
ss.setFont(f1);
add(ss);
add(c);
c.setBounds(730, 2, 300,50);
ss.setBounds(760,2,300, 50);
c.setFont(f1);
mm.setFont(f1);
mm1.setFont(f1);
add(mm);

SimpleDateFormat dFormet=new SimpleDateFormat("dd/MM/yyyy");
Date date=new Date();
da.setText(dFormet.format(date));


		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Who wants to be a Millionaire");
		width = (int)screenSize.getWidth();
		height=(int)screenSize.getHeight();
		this.p=p;
		pname.setText("Participant : " + p.getName());
		pcity.setText("City : "+p.getCity());
		setSize(width,height );
		setVisible(true);
		add(spmain);
		int locmain = (int)(width * 0.70);
		int locright = (int)(height *0.70);
		spmain.setDividerLocation(locmain);
		spright.setDividerLocation( locright );
	
		
		pques.setLayout(new GridLayout(12, 1,20,10));
	
		pques.add(new JLabel("                                                          Questions : Prizes"));
		
		for(int i=9;i>=0;i--)
		{
			btnQuesno[i]=new JButton("Q"+ (i+1)+" : "+prizes[i]);
			
			pques.add(btnQuesno[i]);
			
		}
		original = btnQuesno[0].getBackground();
		btnQuesno[0].setBackground(Color.orange);
		
		
		plife.setLayout(new GridLayout(1,3,5,5));
		plife.add(btnFlip);
		btnFlip.setToolTipText("Flip");
		plife.add(btn50);
		btn50.setToolTipText("Fifty Fifty");
		plife.add(btnPhone);
		btnPhone.setToolTipText("Phone A Friend");
		
		time=new Timer(1000, new ActionListener() {
			@Override
					public void actionPerformed(ActionEvent e) {
						ss.setText(String.valueOf(sec));
						mm1.setText(String.valueOf(min));
		if(sec==60) {
			sec=0;
			min++;
			if(min==10) {
				time.stop();
		     //   tim();
		//tally();
		}
		}sec++;
					}
				}
			);
				time.start();
				
		
		btnFlip.addActionListener(this);
		btn50.addActionListener(this);
		btnPhone.addActionListener(this);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		fillques();
		setupquiz();
		showques();
	}
	
	public void fillques()
	{
		/*for(int i=1;i<=10;i++)
		liques.add(new Question(i, "ques"+i, "option1"+i, "option2"+i, "option3"+i, "option4"+i, "1"));
		*/
		
		liques.add(new Question(1,"Who discovered Uranus? ","Herschel ", "Galileo", "Copernicus ", "None of these ","1"));
		liques.add(new Question(2,"According to Hindu Mythology, which of these is a brother of God Krishna ?","Ram ", "Balram ", "Arjun ", "Parsuram","2"));
		liques.add(new Question(3," In the U.S., something traditional is often said to be\"as American as\" what?","Apple Pie ", "Franks and Beans ", "AmericanPie ", "Macaroni and cheese ","1"));
		liques.add(new Question(4,"The velocity of light was first measured by","Einstein", "Newton ", "Romer ", "Galileo","3"));
		liques.add(new Question(5,"Study of life in outer space is known as","Endobiology ", "Exobiology", "Enterobiology","Neobiology ","2"));
		liques.add(new Question(6,"Oncology is the study of ","Birds", "Cancer", "Mammals", "Soil","2"));
		liques.add(new Question(7,"What was the name of India's first unmanned lunarspacecraft launched in October 2008?","Chandravahaan 1" , "Chandrayaan 1 ", "Chandravimaan 1", "Chadrakhoj 1","2"));
		liques.add(new Question(8,"The credit of developing the polio vaccine goes to","Jonas Salk ", "Alb E. Sabin ", "Selman Waksman ", "None of these ","1"));
		liques.add(new Question(9,"The scientist who first discovered that the earth revolves round the sun was","Newton", "Dalton", "Copernicus", "Einstein","3"));
		liques.add(new Question(10,"Centigrade & Fahrenheit scales give same reading at","- 40 degree", "- 32 degree", "- 273 degree", "- 100 degree","1"));
		liques.add(new Question(11,"The unit of energy in MKS system is","Volt", "Erg", "Ohm", "Joule","4"));
		liques.add(new Question(12,"Which of the following instruments is used to measure pressure of gases?","Barometer ", "Manometer ", "Saccharimeter ","Lactometer ","2"));
		liques.add(new Question(13,"Where is the headquarters of Microsoft located?","Santa Clara, California ", "Tucson, Arizona ","Richmond, Virginia ", "Redmond, Washington","4"));
		liques.add(new Question(14,"'.BAT' extension refers usually to what kind of file?","Compressed Archive file ", "System file ", "Audio file ", "Backup file ","2"));
		liques.add(new Question(15,"What is the highest score in international testcricket?","333","427","400 *","512","3"));
		liques.add(new Question(16,"What was the overall medal tally for the Indiancontingent at the Glasgow Commonwealth Games 2014?","62","58","64","65","2"));
		liques.add(new Question(17,"Which of these laws helps specifically in calculatingcurrent in complex circuits with multiple cells?","Kirchoff's law","Coulomb's law","Ohm'slaw","Gauss' theorem","1"));
		liques.add(new Question(18,"The photoelectric effect was explained effectively byEinstein on the basis of what?","Special relativity","Planck's quantumtheory","Rutherford's postulates","Crystal field theory","2"));
		Collections.shuffle(liques);
	}
	
	public void showques()
	{
		lbQuesno.setText("QNo : "+(qno+1));
		qu = liques.get(qno);
		txtQues.setMargin(new Insets(10,10,10,10));
		
		txtQues.setText(qu.getQues() );
		btnOption1.setText(qu.getOption1());
		btnOption2.setText(qu.getOption2());
		btnOption3.setText(qu.getOption3());
		btnOption4.setText(qu.getOption4());
		
	}
	
	public void setupquiz()
	{
		
		p1.setLayout(null);
		lblLogo.setBounds(350,45,150,150);
		p1.add(lblLogo);
		
		pname.setFont(fo1);
		pcity.setFont(fo1);
		
	//	ppart.add(pname);
	//	ppart.add(pcity);
		//ppart.setSize(150,100);
	//	p1.add(ppart);
		
	//	ppart.setBounds(500,80,200,100);
		
		lbQuesno.setBounds(30, 210, 80, 40);
		lbQuesno.setFont(foTitle);
		p1.add(lbQuesno);
		
		txtQues.setBounds(120, 210, 650, 100);
		txtQues.setLineWrap(true);
		txtQues.setWrapStyleWord(true);
		txtQues.setBackground(Color.BLACK);
		txtQues.setForeground(Color.WHITE);
		txtQues.setFont(foTitle);
		txtQues.setText("");
		p1.add(txtQues);
		
		
		lop1.setBounds(100, 350, 20, 30);
		lop1.setFont(foTitle);
		p1.add(lop1);
	
		btnOption1.setBounds(130, 350, 280, 30);
		btnOption1.setFont(foTitle);
		btnOption1.setBackground(Color.orange);
		p1.add(btnOption1);
		
		
		lop2.setBounds(430, 350, 20, 30);
		lop2.setFont(foTitle);
		p1.add(lop2);
		
		btnOption2.setBounds(460, 350, 280, 30);
		btnOption2.setFont(foTitle);
		btnOption2.setBackground(Color.orange);
		p1.add(btnOption2);
		
		
		lop3.setBounds(100, 400, 20, 30);
		lop3.setFont(foTitle);
		p1.add(lop3);
		
		
		btnOption3.setBounds(130, 400, 280, 30);
		btnOption3.setFont(foTitle);
		btnOption3.setBackground(Color.orange);
		p1.add(btnOption3);
		
		
		lop4.setBounds(430, 400, 20, 30);
		lop4.setFont(foTitle);
		p1.add(lop4);
		
		
		btnOption4.setBounds(460, 400, 280, 30);
		btnOption4.setFont(foTitle);
		btnOption4.setBackground(Color.orange);
		p1.add(btnOption4);
	
		
		btnLock.setBounds(350, 480, 280, 30);
		btnLock.setFont(foTitle);
		p1.add(btnLock);
	
		
		/*btnNext.setBounds(350, 600, 280, 30);
		btnNext.setFont(foTitle);
		p1.add(btnNext);*/
	
		btnOption1.addActionListener(this);
		btnOption2.addActionListener(this);
		btnOption3.addActionListener(this);
		btnOption4.addActionListener(this);
		btnLock.addActionListener(this);
		
		back=new JLabel(" ",img,JLabel.CENTER);
		back.setBounds(0,0,900,730);                   
		p1.add(back); 
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOption1)
		{
			btnOption1.setBackground(selcol);
			btnOption2.setBackground(Color.ORANGE);
			btnOption3.setBackground(Color.ORANGE);
			btnOption4.setBackground(Color.ORANGE);
		}
		else
			if(e.getSource()==btnOption2)
			{
				btnOption2.setBackground(selcol);
				btnOption1.setBackground(Color.ORANGE);
				btnOption3.setBackground(Color.ORANGE);
				btnOption4.setBackground(Color.ORANGE);
			}
			else
		if(e.getSource()==btnOption3)
		{
			btnOption3.setBackground(selcol);
			btnOption1.setBackground(Color.ORANGE);
			btnOption2.setBackground(Color.ORANGE);
			btnOption4.setBackground(Color.ORANGE);
		}
		else
		if(e.getSource()==btnOption4)
		{
			btnOption4.setBackground(selcol);
			btnOption1.setBackground(Color.ORANGE);
			btnOption2.setBackground(Color.ORANGE);
			btnOption3.setBackground(Color.ORANGE);
		}
		else
			if(e.getSource()==btnPhone)
			{
				if(phone==true)
				{
					
					JOptionPane.showMessageDialog(this, "Calling your friend......", "Phone A Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/phone.jpg"));
					btnPhone.setIcon(new ImageIcon("C:/Users/juhit/Downloads/crossbtnphone.jpg"));
				    phone=false;	
				}
			}
			else
				if(e.getSource()==btnFlip)
				{
					if(flip==true)
					{
						
						int res =JOptionPane.showConfirmDialog(this, "Sure you want to flip the question ");
						
						if(res==JOptionPane.YES_OPTION)
						{
						liques.set(qno, liques.get(10));
						showques();
						btnFlip.setIcon(new ImageIcon("C:/Users/juhit/Downloads/crossbtnflip.jpg"));
						flip=false;
						}
					}
					
				}
				else
					if(e.getSource()==btn50)
					{
					String ans = liques.get(qno).getAnswer();
					if(ans.equals("1"))
					{
						btnOption2.setText("");
						btnOption4.setText("");
					}
					else
						if(ans.equals("2"))
						{
							btnOption1.setText("");
							btnOption3.setText("");
						}	
						else
							if(ans.equals("3"))
							{
								btnOption1.setText("");
								btnOption4.setText("");
							}	
							else
								if(ans.equals("4"))
							{
								
									btnOption2.setText("");
									btnOption3.setText("");
							}
					    btn50.setIcon(new ImageIcon("C:/Users/juhit/Downloads/crossbtn50.jpg"));
						fifty=false;
					}
		else
			if(e.getSource()==btnLock)
			{
				boolean correct=false;
				String ans=qu.getAnswer();
				if(ans.equals("1"))
				{
					if(btnOption1.getBackground()==selcol)
					{
						
						JOptionPane.showMessageDialog(this, "Congratulations ! You answered it right !! ");
						correct=true;
					}
					else
						JOptionPane.showMessageDialog(this, "Sorry ! Incorrect Answer!", "Incorrect",JOptionPane.ERROR_MESSAGE);
					
					
					
				}
				else
					if(ans.equals("2"))
					{
						if(btnOption2.getBackground()==selcol)
						{
							correct=true;	
							JOptionPane.showMessageDialog(this, "Congratulations ! You answered it right !! ");
							
						}
						else
							JOptionPane.showMessageDialog(this, "Sorry ! Incorrect Answer!", "Incorrect",JOptionPane.ERROR_MESSAGE);
						
					}
				if(ans.equals("3"))
				{
					if(btnOption3.getBackground()==selcol)
					{
						correct=true;
						JOptionPane.showMessageDialog(this, "Congratulations ! You answered it right !! ");
						
					}
					else
						JOptionPane.showMessageDialog(this, "Sorry ! Incorrect Answer!", "Incorrect",JOptionPane.ERROR_MESSAGE);
					
				}
				if(ans.equals("4"))
				{
					if(btnOption4.getBackground()==selcol)
					{
						correct=true;
						JOptionPane.showMessageDialog(this, "Congratulations ! You answered it right !! ");
						
					}
					else
						JOptionPane.showMessageDialog(this, "Sorry ! Incorrect Answer!", "Incorrect",JOptionPane.ERROR_MESSAGE);
					
				}
					
				if(correct==true)
				{
				btnQuesno[qno].setBackground(Color.RED);
				
				if(qno < 9 )
				{
				btnQuesno[qno+1].setBackground(Color.ORANGE);
				qno++;
				showques();
				}
				else
				{
					JOptionPane.showMessageDialog(this, " Your are a REAL CHAMPION !! Your are a Millionaire  ");
				
			    ThankUScreen tu = new ThankUScreen(p.getName());
			    this.setVisible(false);
				}
				}
				else
					if(qno!=0)
					{
					JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME  ! U win a "+prizes[qno-1]);
					btnLock.setEnabled(false);
					ThankUScreen tu = new ThankUScreen(p.getName());
				    this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME  ! ");
						btnLock.setEnabled(false);
						ThankUScreen tu = new ThankUScreen(p.getName());
					    this.setVisible(false);
					}
				btnOption4.setBackground(Color.ORANGE);
				btnOption1.setBackground(Color.ORANGE);
				btnOption2.setBackground(Color.ORANGE);
				btnOption3.setBackground(Color.ORANGE);
			}
			else
				if(e.getSource()==btnNext)
				{
					
					
					qno++;
					
				}
	}

}

