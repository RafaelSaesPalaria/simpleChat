package simpleChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

import simpleChat.panes.Components;

public class Cliente {

	//Fields
	private static int defaultPort = 3009;
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	
	//Constructor
	public Cliente() {
		this(defaultPort);
	}
	public Cliente(int port) {
		this("localhost", port);
	}
	public Cliente(String host, int port) {
		try {
			socket = new Socket(host,port);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			receive();
			if (socket.isConnected()) {
				Main.getScreen().replacePane(Main.getChatPane());
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String message) {
		try {
			bufferedWriter.write(message);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException ex) {
			closeEverything();
		}
	}
	
	public void receive() {
		new Thread() {
			public void run() {
				String msg;
				while (socket.isConnected()) {
					try {
						msg = bufferedReader.readLine();
						((JTextArea)Components.findComponent(Main.getChatPane(), "Global_Messages")).append("\n"+msg);
					} catch (IOException ex) {
						closeEverything();
					}
				}
			}
		}.start();
	}
	
	public void closeEverything() {
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