package simpleChat;

public class Main {

	//Fields
	private static Screen screen;
	
	//Constructor
	public static void main(String[] args) {
		screen = new Screen();
	}
	
	//IO
	public static Screen getScreen() {
		return screen;
	}
}
