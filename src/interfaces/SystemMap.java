package interfaces;

import java.awt.event.KeyEvent;

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
		world = new WorldBuilder(screenWidth, screenHeight).makeSystem().build();
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void drawViewBar(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		
	}

}
