package simpleChat;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPane extends JPanel{

	//Fields
	private Font font = new Font("Arial",Font.PLAIN,15);
	private Dimension size;
	
	//Constructor
	public MainPane() {
		size = Main.getScreen().getContentPane().getSize();
		
		setSize(size);
		setBackground(Color.yellow);
		setLayout(null);
		createComponents();
	}
	
	//Methods
	public void createComponents() {
		add(createTextField(		 300,400,160, 28));
		add(createJLabel("Hosting"	,300,280,200,200));
		add(createButton("Host"		,200,370, 70, 35));
		add(createButton("Connect"	,200,406, 70, 35));
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
		jbl.setFont(font);
		return jbl;
	}
	
	public JTextField createTextField(int x, int y, int w, int h) {
		JTextField txt = new JTextField();
		txt.setBounds(x, y, w, h);
		txt.setAlignmentY(CENTER_ALIGNMENT);
		txt.setFont(font);
		return txt;
	}
}
