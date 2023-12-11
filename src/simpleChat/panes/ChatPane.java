package simpleChat.panes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simpleChat.Cliente;
import simpleChat.Main;

public class ChatPane extends JPanel{

	//Fields
	private Dimension size;
	
	//Constructor
	public ChatPane() {
		size = Main.getScreen().getContentPane().getSize();
		
		setSize(size);
		setBackground(Color.white);
		setLayout(null);
		createComponents();
		repaint();
	}
	
	//Methods
	public void createComponents() {
		Components.createTextField(this,"Message", 20,20,160, 35);
		Components.createJLabel(this,"Name"	 	 , 20,65, 50, 35);
		Components.createButton(this,"Send",() -> send(),109,65, 70, 35);
		Components.createTextArea(this,"Global_Messages", 200, 20, 270,400);
	}
	
	public void send() {	
		Main.getCliente().send(((JTextField) Components.findComponent(Main.getChatPane(), "Message")).getText());
	}
}
