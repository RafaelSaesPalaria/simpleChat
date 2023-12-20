package simpleChat.panes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simpleChat.Cliente;
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
		Components.createTextField(this,"Adress",300,406,160, 35);
		Components.createJLabel(this,"Hosting"	,300,370,200, 35);
		Components.createButton(this,"Host"		,() -> host(),220,370, 70, 35);
		Components.createButton(this,"Connect"	,() -> connect(),220,406, 70, 35);
	}
	
	public void host() {
		JTextField c = (JTextField) Components.findComponent(this,"Adress");
		String ctxt = c.getText();
		
		if (ctxt.length()>0) {
			new Server(Integer.parseInt(ctxt));
		} else {
			new Server(defaultPort);
		}
		
		connectClient();
	}
	
	public void connect() {
		connectClient();
	}
	
	public void connectClient() { // x.xx:yy || yy || --
		JTextField c = (JTextField) Components.findComponent(this,"Adress");
		String[] adress = new String[2];
		String[] ctxt = c.getText().split(":");
		if (ctxt.length==2) {
			adress = ctxt;
			Main.setCliente(new Cliente(adress[0],Integer.valueOf(adress[1])));
		} else if (ctxt.length==1) {
			System.out.println(ctxt.length);
			Main.setCliente(new Cliente(Integer.valueOf(c.getText())));
		} else {
			Main.setCliente(new Cliente(defaultPort));
		}
	}
	
}
