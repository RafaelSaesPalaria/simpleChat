package simpleChat;

import java.io.IOException;
import java.net.Socket;

public class Client {

	//Fields
	private static int defaultPort = 3009;
	
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
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
