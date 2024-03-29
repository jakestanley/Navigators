package interfaces;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public interface Screen {

	public void displayOutput(AsciiPanel terminal);
	public Screen respondToUserInput(KeyEvent key);
	public void drawViewBar(AsciiPanel terminal); // current screen should be highlighted.

}
