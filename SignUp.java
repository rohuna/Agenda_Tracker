	//Outside imports used
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.io.*;
	import java.util.*;
	
	public class SignUp{
		private JFrame frame = new JFrame();
	
		private HashMap<String, String> map = new HashMap<String, String>();
	
		public static void main(String[] args) {
			SignUp ai = new SignUp();
			ai.setUp();
		}
	
		public void setUp() {
			MasterPanel mp = new MasterPanel();
			frame = new JFrame("Agenda Tracker Login");
			frame.setVisible(true);
			frame.setSize(500, 600);
			frame.setLocation(0, 0);
	
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.add(mp);
		}
		
	
	class MasterPanel extends JPanel implements MouseListener, MouseMotionListener
	{
		JTextField userName, passWord, firstName, lastName, confirmPassword;
		JLabel text1  = new JLabel(" Enter first name: ");
		JLabel text2  = new JLabel(" Enter last name: ");
		JLabel text3  = new JLabel(" Enter a username: ");
		JLabel text4  = new JLabel(" Enter a password: ");
		JLabel text5  = new JLabel(" Confirm your password: ");
		Font font = new Font("Monospace", Font.PLAIN, 20); 
		JButton continue1; 
		boolean displayError;
				boolean changeColor1;
			Font allFont = new Font("Monospaced", Font.BOLD, 18);
				Color specialGray = new Color(150, 150, 150);
	
		String first, last, user, pass;
		MasterPanel()
		{
			//Background is blue
			addMouseListener(this);
			addMouseMotionListener(this);
			setLayout(null);
			text1.setBounds(0 ,100, 200, 20);
			add(text1);
			
			text2.setBounds(0 ,160, 200, 20);
			add(text2);
			
			text3.setBounds(0 ,220, 200, 20);
			add(text3);
			
			text4.setBounds(0 ,280, 200, 20);
			add(text4);
			
	
			//Draws a search bar
			firstName = new JTextField();
			firstName.setBounds(170,95, 300, 20);
			add(firstName);
			
			lastName = new JTextField();
			lastName.setBounds(170,155, 300, 20);
			add(lastName);
			
			userName = new JTextField();
			userName.setBounds(170,215, 300, 20);
			add(userName);
			
			passWord = new JTextField();
			passWord.setBounds(170,275, 300, 20);
			add(passWord);
			
	
	
	
			//Draws a button
			//ButtonListener bl = new ButtonListener();
			//continue1 = new JButton("Continue");
			//continue1.setBounds(200,500,100,50);
			//continue1.addActionListener(bl);
			//add(continue1);
		}
		
		public void paintComponent(Graphics g) 
		{ 
			super.paintComponent(g);
			g.setFont(allFont);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
			if(changeColor1)specialGray = new Color(200, 200, 200);
			if(!changeColor1)specialGray = new Color(150, 150, 150);
			g.setColor(specialGray);
			g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	
			Image background = new ImageIcon("pic532.jpg").getImage();
			g.drawImage(background, 0, 0, 500, 600, null);
			g.fillRect(200, 500-50, 100, 50);
			g.setColor(Color.GRAY);
			g.drawRect(200, 500-50, 100, 50);
			g.setColor(Color.BLACK);
			g.drawString("Continue", 205, 530-50);
			g.setFont(new Font("Monospace", Font.BOLD, 36));
			g.drawString("Sign Up", 150, 50);
			changeColor1 = false;
			
	
		}
	
			public void mousePressed(MouseEvent e) // Recieves mouse input
			{
				if(e.getX()>200 && e.getX()<300 && e.getY()>500-50 && e.getY()<550-50)
				changeColor1 = true;
	
				repaint();
			}
			public void mouseReleased(MouseEvent e) // Recieves mouse input
			{
				if(e.getX()>200 && e.getX()<300 && e.getY()>500-50 && e.getY()<550-50)
				{
				first = firstName.getText();
				last = lastName.getText();
				user = userName.getText();
				pass = passWord.getText();
	
			
			
	
				Login l = new Login();
				l.setUp();
				String outFileName = new String ("Login.txt");    
			File outFile = new File("Login.txt");
			BufferedWriter makesOutput = null;
			try 
			{    
			  makesOutput = new BufferedWriter( new FileWriter(outFileName, true ));
			  makesOutput.write("First Name: " + first + "\n");
			makesOutput.write("Last Name: " + last + "\n");
			makesOutput.write("Username: " + user + "\n");
			makesOutput.write("Password: " + pass + "\n\n");
			makesOutput.close();
			}
			catch (IOException ei) 
			{ 
			  System.err.println("Cannot create " +  outFileName + 
								 " file to be written to.");   
			  System.exit(1);
			}	
			map.put(user, pass);
			frame.dispose();
			
	}
	
				repaint();
			}
			public void mouseClicked(MouseEvent e) // Recieves mouse input
			{
				requestFocus();
				if(e.getX()>200 && e.getX()<300 && e.getY()>500-50 && e.getY()<550-50)
				{
			first = firstName.getText();
			last = lastName.getText();
			user = userName.getText();
			pass = passWord.getText();
	
			
			
				Login l = new Login();
				l.setUp();
	
				String outFileName = new String ("Login.txt");    
			File outFile = new File("Login.txt");
			BufferedWriter makesOutput = null;
			try 
			{    
			  makesOutput = new BufferedWriter( new FileWriter(outFileName, true ));
			  makesOutput.write("First Name: " + first + "\n");
			makesOutput.write("Last Name: " + last + "\n");
			makesOutput.write("Username: " + user + "\n");
			makesOutput.write("Password: " + pass + "\n\n");
			makesOutput.close();
			}
			catch (IOException ex) 
			{ 
			  System.err.println("Cannot create " +  outFileName + 
								 " file to be written to.");   
			  System.exit(1);
			}
			map.put(user, pass);
	
	frame.dispose();
	}
	
				repaint();
			}
			public void mouseExited(MouseEvent e) // Recieves mouse input
			{
				
			}
			public void mouseEntered(MouseEvent e) // Recieves mouse input
			{
				
			}
			public void mouseDragged(MouseEvent e) // Recieves mouse input
			{
				
			}
			public void mouseMoved(MouseEvent e) // Recieves mouse input
			{
				if(e.getX()>200 && e.getX()<300 && e.getY()>500-50 && e.getY()<550-50)
				changeColor1 = true;
				else changeColor1 = false;
				repaint();
				
			}
			
		
	
	}
	
	
	}
	
