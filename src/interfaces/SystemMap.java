package interfaces;

import java.awt.event.KeyEvent;

import begin.Game;
import components.World;
import components.WorldBuilder;
import asciiPanel.AsciiPanel;

/**
 * The SystemMap class
 * @author stanners & trysten
 * 
 * SystemMap is based on Trysten's code again, as is ShipMap (formerly known as RogueMap).
 * Maybe maps should be a class? I don't like the screen object interfacing with anything 
 * other than gets and terminal output. Rather than creating a new world object in every 
 * render, it will surely be much more efficient to use an already instantiated one.
 * 
 * The code will become perfect...
 *
 */

public class SystemMap extends Map implements Screen {
	
	public SystemMap(int width, int height){
		super(width, height); // TODO check variables
		createWorld();
	}
	
	private void createWorld(){
		world = new WorldBuilder(worldWidth, worldHeight).makeSystem().build();
	}

	public void displayOutput(AsciiPanel terminal) {
		drawViewBar(terminal); 
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write('X', centerX - left, centerY - top);
		
		terminal.writeCenter("Indev Navigators Ship Overview - CCBY Jake Stanley", 21);
	}

	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
//		case KeyEvent.VK_ESCAPE: return new LoseScreen(); // later
//		case KeyEvent.VK_ENTER: return new WinScreen(); // later
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_H: scrollBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_L: scrollBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_K: scrollBy( 0,-1); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_J: scrollBy( 0, 1); break;
		case KeyEvent.VK_Y: scrollBy(-1,-1); break;
		case KeyEvent.VK_U: scrollBy( 1,-1); break;
		case KeyEvent.VK_B: scrollBy(-1, 1); break;
		case KeyEvent.VK_N: scrollBy( 1, 1); break;
		case KeyEvent.VK_M: return new PlayScreen();
		case KeyEvent.VK_P: return new ShipMap(37, 19);
		case KeyEvent.VK_R: return new CrewScreen();
		}
		
		return this;
	}

	@Override
	public void drawViewBar(AsciiPanel terminal) {
		int line = Game.viewBarLine;
		terminal.write(" (M)AIN ", 1, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing - these need to be strings and we need to use the string length method.
		terminal.write(" C(R)EW ", 10, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" MA(P) ", 19, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" (S)YSTEM ", 27, line, terminal.brightWhite, terminal.brightGreen); // TODO intelligent spacing
	}

}
