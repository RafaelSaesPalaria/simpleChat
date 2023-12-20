package simpleChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

	//Fields
	private static ArrayList<ClientHandler> clientHandlers = new ArrayList();
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	
	//Constructor
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader (socket.getInputStream ()));
			clientHandlers.add(this);
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	
	//Inhered Methods
	@Override
	public void run() {
		String messageFromClient;
		while (socket.isConnected()) {
			try {
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			} catch (Exception e) {
				closeEverything(socket, bufferedReader, bufferedWriter);
				break;
			}
		}
	}
	
	public void broadcastMessage(String message) {
		 for (ClientHandler clientHandler : clientHandlers) {
			 try {
				clientHandler.bufferedWriter.write(message);
				clientHandler.bufferedWriter.newLine();
				clientHandler.bufferedWriter.flush();
			 } catch (IOException e) {
				closeEverything(socket, bufferedReader, bufferedWriter);
			 }
		 }
	}
	
	public void removeClientHandler() {
		clientHandlers.remove(this);
	}
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader ,BufferedWriter bufferedWriter) {
		removeClientHandler();
		try {
			if (socket!=null) {
				socket.close();
			}
			if (bufferedWriter!=null) {
				bufferedWriter.close();
			}
			if (bufferedReader!=null) {
				bufferedReader.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
