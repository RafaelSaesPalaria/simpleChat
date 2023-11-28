package simpleChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import simpleChat.panes.Components;

public class ClientHandler {

	//Fields
	private Socket socket;
	private String message = "";
	
	//Constructor
	public ClientHandler(Socket socket) {
		this.socket = socket;
		threadrun();
	}
	
	//Methods
	public void write() throws IOException {
        DataOutputStream dos;
        dos = new DataOutputStream(socket.getOutputStream());
	    JTextArea globalMessages = (JTextArea) Components.findComponent(Main.getChatPane(), "Global_Messages");
	    String messageToSend = globalMessages.getText();
	    if (!message.equals(globalMessages.getText())) {
	    	dos.writeUTF(messageToSend);
	    	dos.flush(); // Important: flush the stream to ensure data is sent immediately
	   }
    }
	
	public void read() throws IOException {
        DataInputStream dis;
		dis = new DataInputStream(socket.getInputStream());
	    JTextArea globalMessages = (JTextArea) Components.findComponent(Main.getChatPane(), "Global_Messages");
	    String receivedMessage = dis.readUTF();
	    globalMessages.setText(receivedMessage);
	    message = globalMessages.getText();
    }
	
	//Inhered Methods
	public void threadrun() {
	    new Thread() {
	        public void run() {
	            while (true) {
	                System.out.println("run check");

	                try {
	                    write();
	                    sleep(100);
	                } catch (InterruptedException | IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }.start();

	    new Thread() {
	        public void run() {
	            while (true) {
	                try {
	                    read();
	                    sleep(100);
	                } catch (InterruptedException | IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }.start();
	}

}
