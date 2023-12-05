package simpleChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	//Fields
	private ServerSocket serverSocket;
	
	//Constructor
	public Server() {
		this(3009);
	}
	
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			Main.getScreen().replacePane(Main.getChatPane());
			new Thread() {
				public void run() {
					while (!serverSocket.isClosed()) {
						Socket socket;
						try {
							socket = serverSocket.accept();
							System.out.println("A new Client has connected");
							ClientHandler clientHandler = new ClientHandler(socket);
							Thread thread = new Thread();
							thread.start();
						} catch (IOException e) {
							e.printStackTrace();
							
						}
					}
				}
			}.start();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void closeServerSocket() {
		try {
			if (serverSocket!=null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
