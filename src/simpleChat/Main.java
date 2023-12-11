package simpleChat;

import simpleChat.panes.ChatPane;
import simpleChat.panes.MainPane;

public class Main {

	//Fields
	private static Screen screen;
	private static ChatPane chatPane;
	private static MainPane mainPane;
	private static Cliente cliente;
	
	//Constructor
	public static void main(String[] args) {
		screen = new Screen();
		chatPane=new ChatPane();
		mainPane=new MainPane();
		
		
		screen.replacePane(mainPane);
	}
	
	//IO
	public static Screen getScreen() {
		return screen;
	}
	
	public static ChatPane getChatPane() {
		return chatPane;
	}
	
	public static MainPane getMainPane() {
		return mainPane;
	}
	
	public static Cliente getCliente() {
		return cliente;
	}
	
	public static void setCliente(Cliente cliente) {
		Main.cliente = cliente;
	}
}
