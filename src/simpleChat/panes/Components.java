package simpleChat.panes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Components {

	//Fields
	private static Font font = new Font("Arial",Font.PLAIN,15);
	
	//Methods
	public static void createButton(JPanel jpanel, String txt,Runnable rn, int x,int y,int w,int h) {
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
		jpanel.add(btn);
	}
	
	public static void createJLabel(JPanel jpanel, String txt, int x, int y, int w, int h) {
		JLabel jbl = new JLabel(txt);
		jbl.setName(txt);
		jbl.setBounds(x, y, w, h);
		jbl.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		jbl.setFont(font);
		jpanel.add(jbl);
	}
	
	public static void createTextField(JPanel jpanel, String name,int x, int y, int w, int h) {
		JTextField txt = new JTextField();
		txt.setName(name);
		txt.setBounds(x, y, w, h);
		txt.setBorder(BorderFactory.createLineBorder(Color.black));
		txt.setAlignmentY(JTextField.CENTER_ALIGNMENT);
		txt.setFont(font);
		jpanel.add(txt);
	}
	
	public static void createTextArea(JPanel jpanel,String name, int x, int y, int w, int h) {
		JTextArea txt = new JTextArea();
		txt.setName(name);
		txt.setBounds(x, y, w, h);
		txt.setBorder(BorderFactory.createLineBorder(Color.black));
		txt.setBackground(new Color(255,255,245));
		txt.setLineWrap(true);
		txt.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
		txt.setFont(font);
		jpanel.add(txt);
	}
	
	public static Component findComponent(JPanel jpanel,String name) {
		for (Component c : jpanel.getComponents()) {
			if (c.getName()!=null) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
}
