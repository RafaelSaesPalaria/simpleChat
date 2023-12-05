package simpleChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import simpleChat.panes.Components;

public class Client {
	
	//Fields
	private Socket socket;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	
	//Constructors
	public Client() {
		this(3009);
	}
	
	public Client(int port) {
		this("localhost",3009);
	}
	
	public Client(String host, int port) {
		try {
			socket = new Socket(host,port);
			Main.getScreen().replacePane(Main.getChatPane());
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			receive();
		} catch (Exception e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	
	//Methods
	public void send(String message) {
		try {
			System.out.println("Client send a message");
			bufferedWriter.write(message);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive() {
		new Thread() {
			public void run() {
				String msg;
				try {
					while (socket.isConnected()) {
						System.out.println("Client is about to read a message");
						msg = bufferedReader.readLine();
						System.out.println("Client read a message");
						System.out.print("Message Received: "+msg);
						((JTextArea)Components.findComponent(Main.getChatPane(), "Global_Messages")).setText(
						((JTextArea) Components.findComponent(Main.getChatPane(), "Global_Messages")).getText()+
						msg+"\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader ,BufferedWriter bufferedWriter) {

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
