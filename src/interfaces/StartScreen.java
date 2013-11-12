package interfaces;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	public StartScreen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		terminal.write("Navigators", 1, 1);
		terminal.write("Commander OS 0.12", 1, 2);
		terminal.write("System ready", 1, 3);
		terminal.writeCenter("--press [enter] to start--", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
//		return key.getKeyCode() == KeyEvent.VK_ENTER ? new RogueMap() : this; // TODO get to grips with how this works, not currently 100% sure
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}

}
