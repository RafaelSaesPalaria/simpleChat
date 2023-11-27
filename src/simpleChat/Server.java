package simpleChat;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	//Fields
	private ServerSocket serverSocket;
	
	//Constructor
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			serverThread();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serverThread() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
						System.out.println("New client");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
