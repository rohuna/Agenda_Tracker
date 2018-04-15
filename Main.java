import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.*;

public class Main {

	JFrame frame;
	WelcomePage wp;
	private static SimpleTimeZone pdt;

	public static void main(String[] args) {
		Main m = new Main();
		m.setUp("______'s Agenda");	
	}
	
	public void setUp(String name) {
		MasterPanel mp = new MasterPanel();
		frame = new JFrame(name);
		frame.setVisible(true);
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(mp);
	}

	@SuppressWarnings("serial")
	class MasterPanel extends JPanel implements ActionListener
	{
		JComboBox<String> attributes;
		JLabel event = new JLabel("Click to add New Event");
		JTextField name = new JTextField("Enter the name of the desired event"), time = new JTextField("0:00"), duration = new JTextField("0:00");
		JLabel eventName = new JLabel("Enter the name of the event"), eventTime = new JLabel("Enter the time of the event"), eventEndTime = new JLabel("Enter the duration of the event (in hrs:mins, e.i. 0:01)");
		JButton button = new JButton("Add");
		ArrayList<String> nameStr = new ArrayList<String>(30), timeStr = new ArrayList<String>(30), endTime = new ArrayList<String>(30), durationStr = new ArrayList<String>(30), typeSelected = new ArrayList<String>(30);
		int index = 0, endHour, endMin, startM = 0, startH = 0, noPrint=0;
		Table table = new Table();
		JTable jt;
		DefaultTableModel model;
		WelcomePage run;

		MasterPanel(){
			Collections.fill(nameStr, " ");
			Collections.fill(timeStr, "0:00");
			Collections.fill(endTime, "0:00");
			Collections.fill(durationStr, "0:00");
			Collections.fill(typeSelected, " ");
			timeStr.add("0:00");
			durationStr.add("0:00");
			setLayout(null);
			event.setBounds(175 ,-50, 200, 200);
			add(event);

			eventName.setBounds(168 ,70, 200, 200);
			add(eventName);

			eventTime.setBounds(168 ,150, 200, 200);
			add(eventTime);

			eventEndTime.setBounds(103 ,230, 400, 200);
			add(eventEndTime);

			attributes = new JComboBox<String>();
			attributes.addActionListener(this);
			attributes.setBounds(150,75,200,25);
			attributes.addItem("Homework");
			attributes.addItem("Study");
			attributes.addItem("Break");
			attributes.addItem("Eat");
			attributes.addItem("Sleep");
			attributes.transferFocus();

			add(attributes);

			name = new JTextField();
			name.setBounds(110,180, 300, 20);
			name.setEditable(true);
			add(name);

			time = new JTextField();
			time.setBounds(110,260, 300, 20);
			time.setEditable(true);

			add(time);

			duration = new JTextField();
			duration.setBounds(110,340,300, 20);
			duration.setEditable(true);

			add(duration);

			button.setBounds(200,400, 100,50);
			add(button);
			button.addActionListener(this);

			//JTable stuff
			table.setLocation(600, 0);
			add(table);
			Timer timer = new Timer(1000, new TimerHandler());
			timer.start();
		}
		
		public class TimerHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
				pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);
				pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
				pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
				Calendar calendar = new GregorianCalendar(pdt);
				Date trialTime = new Date();
				calendar.setTime(trialTime);
				if(noPrint==0)
				{
				for(int i = 1; i < index + 1; i++){
					StringTokenizer st = new StringTokenizer(timeStr.get(i - 1), ":");
					startH = (Integer.parseInt(st.nextToken(":")));
					startM = (Integer.parseInt(st.nextToken()));
					if(calendar.get(Calendar.HOUR) == startH && calendar.get(Calendar.MINUTE) == startM && calendar.get(Calendar.SECOND) < 2){
						String n = typeSelected.get(i-1);

						if(n.equals("Sleep"))
							  wp = new WelcomePage(1);   
						if(n.equals("Eat")) wp = new WelcomePage(2);   
						if(n.equals("Study")) wp = new WelcomePage(3);   
						if(n.equals("Homework")) wp = new WelcomePage(4);   
						if(n.equals("Break")) wp = new WelcomePage(5); 
						noPrint++;
						
					}
				}
				}
				else 
				{
					if(noPrint==1)
					noPrint++;
					if(noPrint<61)
					noPrint = 0;
				}
				

			}
		}

		public void actionPerformed(ActionEvent e) {
			try{
			if(e.getSource().equals(button)){
				typeSelected.add(index, (String) attributes.getSelectedItem());
				timeStr.add(index, time.getText());
				nameStr.add(index, name.getText());
				durationStr.add(index, duration.getText());

				StringTokenizer st = new StringTokenizer(timeStr.get(index), ":");
				startH = (Integer.parseInt(st.nextToken(":")));
				startM = (Integer.parseInt(st.nextToken()));

				st = new StringTokenizer(durationStr.get(index), ":");
				int endH = (Integer.parseInt(st.nextToken(":"))) + startH;
				int endM = (Integer.parseInt(st.nextToken()));
				if(endM + startM >= 60){
					endM = endM + startM - 60;
					endH ++;
				}
				else
				{
					endM = endM+startM;
				}
				endHour = endH;
				endMin = endM;
				if(endM < 10) endTime.add(endH + ":" + endM + "0");
				else endTime.add(endH + ":" + endM);
				index ++;
				table.change();
			}
			}
			catch(Exception exa)
			{}
		}

		public void paintComponent(Graphics g){
			Image backMain = new ImageIcon("backMain.jpg").getImage();
			g.drawImage(backMain, 0, 0, 1000, 600, null);
			g.drawLine(500, 0, 500, 600);
			
		}

		public class Table extends JPanel{    
			Table(){    
				setUp();
			}

			void setUp(){
				setLayout(new GridLayout(0, 1));

				model = new DefaultTableModel();
				model.addColumn("Type");
				model.addColumn("Start Time");
				model.addColumn("End Time");
				model.addColumn("Name");

				jt = new JTable(model) {
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int row, int column) {                
						return false;               
					};
				};
				jt.repaint();
				jt.setBounds(30,40,200,300);          
				JScrollPane sp = new JScrollPane(jt);    
				add(sp);
				setSize(300,400);    
				setVisible(true);    
			}

			void change(){
				String[] data = new String[4];
				data[0] = typeSelected.get(index - 1);
				data[1] = timeStr.get(index - 1);
				data[2] = endTime.get(index - 1);
				data[3] = nameStr.get(index - 1);
				model.addRow(data);
			}
		}
	}
}
