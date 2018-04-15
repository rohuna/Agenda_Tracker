import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;


public class WelcomePage extends JFrame
{    
	Sleep pan1;
	Eat pan2;
	Study pan3;
	Homework pan4;
	Break pan5;
	public WelcomePage(){}
	/*public WelcomePage(boolean boo, int num)
	{
		System.out.print(boo);
		
	}*/
	public WelcomePage(int num)
	{  
		super ("AgendaTracker");
		setSize( 600, 400);    
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
		//setLocation(200,100);
		//setResizable(true);
		if(num == 1){
			pan1 = new Sleep(); 
			
			setContentPane(pan1);  
		}if(num == 2)
		{
			pan2 = new Eat();
			setContentPane(pan2);  
		}if(num == 3){
			pan3 = new Study();  
			setContentPane(pan3);  
		}if(num == 4){
			pan4 = new Homework(); 
			setContentPane(pan4);  
		}if(num == 5){
			pan5 = new Break();   
			setContentPane(pan5);  
		}
		
		setVisible(true);   
	} 

	public static void main (String [] args)   
	{  
		WelcomePage JoeBobKim = new WelcomePage();
		//needed to run constructor
	}

}

class Sleep extends JPanel
{ 
	Font font; 
	Image sleep, star; 
	public Sleep()
	{  
		font = new Font("Desire", Font.PLAIN, 26); 
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{  
		transferFocus();
		super.paintComponent(g);
		star = new ImageIcon("StarrySky.jpeg").getImage(); 
		sleep = new ImageIcon("sleep.png").getImage(); 
		g.drawImage(star, 0, 0, 600, 400, null); 
		g.setColor(Color.white); 
		g.fillRect(100, 100, 400, 150); 
		g.drawImage(sleep, 325, 125, 125, 75, null); 
		g.setColor(Color.black); 
		g.setFont(font); 
		g.drawString("Time to sleep", 125, 175); 
	} 
}

class Eat extends JPanel
{ 
	Font font; 
	Image sleep, star; 
	public Eat()
	{  
		font = new Font("Desire", Font.PLAIN, 26); 
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{  
		transferFocus();
		super.paintComponent(g);
		star = new ImageIcon("food.jpeg").getImage(); 
		g.drawImage(star, 0, 0, 600, 400, null); 
		g.setColor(Color.white); 
		g.fillRect(100, 100, 400, 150); 
		g.drawImage(sleep, 325, 125, 125, 75, null); 
		g.setColor(Color.black); 
		g.setFont(font); 
		g.drawString("Time to eat", 125, 175); 
	} 
}


class Study extends JPanel
{ 
	Font font; 
	Image sleep, star; 
	public Study()
	{  
		font = new Font("Desire", Font.PLAIN, 26); 
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{  
		transferFocus();
		super.paintComponent(g);
		star = new ImageIcon("Study.jpeg").getImage(); 
		g.drawImage(star, 0, 0, 600, 400, null); 
		g.setColor(Color.white); 
		g.fillRect(100, 100, 400, 150); 
		g.drawImage(sleep, 325, 125, 125, 75, null); 
		g.setColor(Color.black); 
		g.setFont(font); 
		g.drawString("Time to study", 125, 175); 
	} 
}

class Homework extends JPanel
{ 
	Font font; 
	Image sleep, star; 
	public Homework()
	{  
		font = new Font("Desire", Font.PLAIN, 26); 
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{  
		transferFocus();
		super.paintComponent(g);
		star = new ImageIcon("Homework.jpeg").getImage(); 
		g.drawImage(star, 0, 0, 600, 400, null); 
		g.setColor(Color.white); 
		g.fillRect(100, 100, 400, 150); 
		g.drawImage(sleep, 325, 125, 125, 75, null); 
		g.setColor(Color.black); 
		g.setFont(font); 
		g.drawString("Time to do your Homework", 125, 175); 
	} 
}

class Break extends JPanel
{ 
	Font font; 
	Image sleep, star; 
	public Break()
	{  
		font = new Font("Desire", Font.PLAIN, 26); 
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{  
		transferFocus();
		super.paintComponent(g);
		star = new ImageIcon("Break.jpg").getImage(); 
		g.drawImage(star, 0, 0, 600, 400, null); 
		g.setColor(Color.white); 
		g.fillRect(100, 100, 300, 50); 
		g.drawImage(sleep, 325, 125, 125, 75, null); 
		g.setColor(Color.black); 
		g.setFont(font); 
		g.drawString("Time to take a Break", 125, 130); 
	} 
}

