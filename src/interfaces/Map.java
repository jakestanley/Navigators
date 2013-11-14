package interfaces;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import components.World;

/**
 * This will be the super class of the SystemMap and ShipMap classes as they have a lot 
 * in common. However, I am wanted (TODO) to change object implementations so they are 
 * handled independently of the screen classes. This is mainly because if I decide to 
 * stop using AsciiPanel, I would like the code to be easily portable.
 * @author stanners
 *
 */

public class Map {
	protected World world;
	protected int centerX;
	protected int centerY;
	protected int screenWidth;
	protected int screenHeight;
	protected int worldWidth;
	protected int worldHeight;
	
	public Map(int worldWidth, int worldHeight){
		this.screenWidth = 37; // not sure if this should be in the constructor
		this.screenHeight = 19; // not sure if this should be in the constructor
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
	}
	
	public int getScrollX(){
		return Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY(){
		return Math.max(0, Math.min(centerY - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	protected void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;
				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
			}
		}
	}
	
	protected void scrollBy(int mx, int my){
		centerX = Math.max(0, Math.min(centerX + mx, world.getWidth() - 1));
		centerY = Math.max(0, Math.min(centerY + my, world.getHeight() - 1));
	}
	
}
