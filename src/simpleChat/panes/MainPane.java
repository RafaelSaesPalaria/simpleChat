package simpleChat.panes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simpleChat.Client;
import simpleChat.Main;
import simpleChat.Server;

public class MainPane extends JPanel{

	//Fields
	private Font font = new Font("Arial",Font.PLAIN,15);
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
		add(createTextField("addres",300,406,160, 35));
		add(createJLabel("Hosting"	,300,370,200, 35));
		add(createButton("Host"		,() -> host(),220,370, 70, 35));
		add(createButton("Connect"	,() -> connect(),220,406, 70, 35));
	}
	
	public void host() {
		new Server(getPort());
	}
	
	public void connect() {
		new Client(getPort());
	}
	
	public int getPort() {
		TextField c = (TextField) findComponent("adress");
		try {
			int port = Integer.parseInt(c.getText());
			return port;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return defaultPort;
		}
	}
	
	public Component findComponent(String name) {
		for (Component c : getComponents()) {
			if (c.getName()!=null) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
	
	public Button createButton(String txt,Runnable rn, int x,int y,int w,int h) {
		Button btn = new Button(txt);
		btn.setName(txt);
		btn.setBounds(x, y, w, h);
		btn.setFont(font);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rn.run();
			}
		});
		return btn;
	}
	
	public JLabel createJLabel(String txt, int x, int y, int w, int h) {
		JLabel jbl = new JLabel(txt);
		jbl.setName(txt);
		jbl.setBounds(x, y, w, h);
		jbl.setAlignmentY(CENTER_ALIGNMENT);
		jbl.setFont(font);
		return jbl;
	}
	
	public JTextField createTextField(String name,int x, int y, int w, int h) {
		JTextField txt = new JTextField();
		txt.setName(name);
		txt.setBounds(x, y, w, h);
		txt.setAlignmentY(CENTER_ALIGNMENT);
		txt.setFont(font);
		return txt;
	}
}
