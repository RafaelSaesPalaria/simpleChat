package simpleChat;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatPane extends JPanel{

	//Fields
	private Font font = new Font("Arial",Font.PLAIN,15);
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
		add(createTextField("Message", 20,20,160, 35));
		add(createJLabel("Nome"	 	 , 20,65, 50, 35));
		add(createButton("Enviar"	 ,109,65, 70, 35));
		add(createTextArea("Global_Messages", 200, 20, 270,400));
	}
	
	public Button createButton(String txt, int x,int y,int w,int h) {
		Button btn = new Button(txt);
		btn.setBounds(x, y, w, h);
		btn.setFont(font);
		return btn;
	}
	
	public JLabel createJLabel(String txt, int x, int y, int w, int h) {
		JLabel jbl = new JLabel(txt);
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
	
	public JTextArea createTextArea(String name, int x, int y, int w, int h) {
		JTextArea txt = new JTextArea();
		txt.setName(name);
		txt.setBounds(x, y, w, h);
		txt.setBorder(BorderFactory.createLineBorder(Color.black));
		txt.setBackground(new Color(255,255,245));
		txt.setLineWrap(true);
		txt.setAlignmentY(CENTER_ALIGNMENT);
		txt.setFont(font);
		return txt;
	}
}
