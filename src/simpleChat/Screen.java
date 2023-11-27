package simpleChat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame{
	
	//Constructor
	public Screen() {
		setTitle("SimpleChat");
		setLayout(null);
		setBounds(200, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//Methods
	public void replacePane(JPanel jpanel) {
		getContentPane().removeAll();
		add(jpanel);
		repaint();
	}
	
}
