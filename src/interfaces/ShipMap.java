package interfaces;

import java.awt.event.KeyEvent;

import begin.Game;
import asciiPanel.AsciiPanel;
import components.World;
import components.WorldBuilder;

/**
 * The ShipMap class
 * @author stanners
 *
 */

public class ShipMap extends Map implements Screen {

	public ShipMap(int width, int height){
		super(width, height);
		createWorld();
	}
	
	private void createWorld(){
		world = new WorldBuilder(screenWidth, screenHeight).makeShip().build(); // TODO work out how to move the map.
	}
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		drawViewBar(terminal); 
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write('X', centerX - left, centerY - top);
		
		terminal.writeCenter("Indev Navigators Ship Overview - CCBY Jake Stanley", 21);
	}

	@Override
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
		case KeyEvent.VK_R: return new CrewScreen();
		}
		
		return this;
	}

	@Override
	public void drawViewBar(AsciiPanel terminal) {
		int line = Game.viewBarLine;
		terminal.write(" (M)AIN ", 1, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" C(R)EW ", 10, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" MA(P) ", 19, line, terminal.brightWhite, terminal.brightGreen); // TODO intelligent spacing
	}
	
}
