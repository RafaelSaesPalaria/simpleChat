package simpleChat.panes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simpleChat.Client;
import simpleChat.Main;
import simpleChat.Server;

public class MainPane extends JPanel{

	//Fields
	private Dimension size;
	private int defaultPort = 3009;
	
	//Constructor
	public MainPane() {
		size = Main.getScreen().getContentPane().getSize();
		
		setSize(size);
		setBackground(Color.white);
		setLayout(null);
		createComponents();
		repaint();
	}
	
	//Methods
	public void createComponents() {
		Components.createTextField(this,"adress",300,406,160, 35);
		Components.createJLabel(this,"Hosting"	,300,370,200, 35);
		Components.createButton(this,"Host"		,() -> host(),220,370, 70, 35);
		Components.createButton(this,"Connect"	,() -> connect(),220,406, 70, 35);
	}
	
	public void host() {
		new Server(getPort());
	}
	
	public void connect() {
		new Client(getPort());
	}
	
	public int getPort() {
		JTextField c = (JTextField) Components.findComponent(this,"adress");
		try {
			int port = Integer.parseInt(c.getText());
			return port;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return defaultPort;
		}
	}
	
}
