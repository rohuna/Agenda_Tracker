//Outside imports used
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Login {
	private JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		Login ai = new Login();
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
		JTextField userName, passWord;
		JLabel text1  = new JLabel(" Username: ");
		JLabel text2  = new JLabel(" Password: ");
		JButton login, signUp;
		boolean changeColor1, changeColor2, changeColor3, breakthru;
		Font allFont = new Font("Monospaced", Font.BOLD, 18);
	Color specialGray = new Color(150, 150, 150);
	boolean drawError;

		MasterPanel()
		{
			addMouseListener(this);
		addMouseMotionListener(this);
			//Background is blue
			setBackground(Color.BLUE);
			setLayout(null);
			text1.setBounds(50 ,150, 100, 10);
			add(text1);

			text2.setBounds(50 ,210, 100, 10);
			add(text2);
	
			//Draws a search bar
			userName = new JTextField();
			userName.setBounds(130,145, 300, 20);
			add(userName);

			passWord = new JTextField();
			passWord.setBounds(130,205, 300, 20);
			add(passWord);


			login = new JButton("Login");
			login.setBounds(210,300,100,50);


			signUp = new JButton("Sign Up");
			signUp.setBounds(210,350,100,50);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
			Image background = new ImageIcon("pic532.jpg").getImage();
			g.drawImage(background, 0, 0, 500, 600, null);
		g.setFont(allFont);
		
		if(changeColor1)specialGray = new Color(200, 200, 200);
		if(!changeColor1)specialGray = new Color(150, 150, 150);
		g.setColor(specialGray);
		g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		if(drawError)
		{
			g.setColor(Color.RED);
			g.drawString("Please enter a valid username and passsword", 10, 100);
			
		}
		g.setColor(specialGray);
		g.fillRect(210, 300, 100, 50);
		g.setColor(Color.GRAY);
		g.drawRect(210, 300, 100, 50);
		g.setColor(Color.BLACK);
		g.drawString("Login", 225, 330);
		
		if(changeColor2)specialGray = new Color(200, 200, 200);
		if(!changeColor2)specialGray = new Color(150, 150, 150);
		g.setColor(specialGray);
		g.fillRect(210, 350+50, 100, 50);
		g.setColor(Color.GRAY);
		g.drawRect(210, 350+50, 100, 50);
		g.setColor(Color.BLACK);
		g.drawString("Sign Up", 225, 380+50);
		g.setFont(new Font("Monospace", Font.BOLD, 36));
		g.drawString("Login", 200, 50);
		}
		public void mousePressed(MouseEvent e) // Recieves mouse input
		{
			if(e.getX()>210 && e.getX()<310 && e.getY()>300 && e.getY()<350)
			changeColor1 = true;
			if(e.getX()>210 && e.getX()<310 && e.getY()>350+50 && e.getY()<400+50)
			changeColor2 = true;

			repaint();
		}
		public void mouseReleased(MouseEvent e) // Recieves mouse input
		{
			if(e.getX()>210 && e.getX()<310 && e.getY()>300 && e.getY()<350)
			{
				String user = userName.getText();
				user.trim();
					String pass = passWord.getText();
					pass.trim();
					try {
			File file = new File("Login.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.equals("Username: "+ user))
				{
				while ((line = bufferedReader.readLine()) != null) {
					if(line.equals("Password: " + pass))
					{

						Main m = new Main();
					m.setUp(user + "'s Agendas");
					frame.dispose();
					breakthru = true;
					break;
					
					}
					else 
					{
						drawError = true;
						fileReader.close();
						repaint();
					}
					
				}	
				}
				if(breakthru) break;
				
			}
			fileReader.close();

		} catch (IOException eo) {
			
		}
					
					
			}
			if(e.getX()>210 && e.getX()<310 && e.getY()>350+50 && e.getY()<400+50)
			{
				SignUp ai = new SignUp();
					ai.setUp();
					frame.dispose();
			}

			repaint();
		}
		public void mouseClicked(MouseEvent e) // Recieves mouse input
		{
			if(e.getX()>210 && e.getX()<310 && e.getY()>300 && e.getY()<350)
			{
				String user = userName.getText();
				user.trim();
					String pass = passWord.getText();
					pass.trim();
					try {
			File file = new File("Login.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.equals("Username: "+ user))
				{
				while ((line = bufferedReader.readLine()) != null) {
					if(line.equals("Password: " + pass))
					{

						Main m = new Main();
					m.setUp(user + "'s Agendas");
					frame.dispose();
					breakthru = true;
					
					break;
					
					}
					else 
					{
						drawError = true;
						fileReader.close();
						repaint();
					}
					
				}	
				}
				if(breakthru) break;
				
			}
			fileReader.close();

		} catch (IOException eoa) {
			
		}
					
					
			}
			if(e.getX()>210 && e.getX()<310 && e.getY()>350+50 && e.getY()<400+50)
			{
				SignUp ai = new SignUp();
					ai.setUp();
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
			if(e.getX()>210 && e.getX()<310 && e.getY()>300 && e.getY()<350)
			changeColor1 = true;
			else changeColor1 = false;
			if(e.getX()>210 && e.getX()<310 && e.getY()>350+50 && e.getY()<400+50)
			changeColor2 = true;
			else changeColor2 = false;

			repaint();
			
		}
		
	}
}


