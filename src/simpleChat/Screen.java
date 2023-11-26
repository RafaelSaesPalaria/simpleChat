package simpleChat;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import simpleChat.panes.MainPane;

public class Screen extends JFrame{

	//Constructor
	public Screen() {
		setTitle("SimpleChat");
		setLayout(null);
		setBounds(200, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		createMainPane();
	}
	
	//Methods
	public void createMainPane() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				add(new MainPane());
			}
		});
	}
	
}
