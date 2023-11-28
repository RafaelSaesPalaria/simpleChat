package simpleChat;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	//Fields
	private ServerSocket serverSocket;
	private List<ClientHandler> clientHandlers = new ArrayList<>();
	
	//Constructor
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			serverThread();
			Main.getScreen().replacePane(Main.getChatPane());
			Main.getChatPane().setBackground(Color.yellow);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serverThread() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						clientHandlers.add(new ClientHandler(serverSocket.accept()));
						System.out.println("New client");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
