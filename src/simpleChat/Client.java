package simpleChat;

import java.io.IOException;
import java.net.Socket;

import javax.swing.SwingUtilities;

public class Client {

	//Fields
	private static int defaultPort = 3009;
	private ClientHandler clientHandler;
	
	//Constructor
	public Client() {
		this(defaultPort);
	}
	public Client(int port) {
		this("localhost", port);
	}
	public Client(String host, int port) {
		try {
			Socket socket = new Socket(host,port);
			
			if (socket.isConnected()) {
				SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Main.getScreen().replacePane(Main.getChatPane());
                    }
                });
				clientHandler = new ClientHandler(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
