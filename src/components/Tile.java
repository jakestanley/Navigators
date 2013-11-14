package components;

import java.awt.Color; // more of trysten's code
import asciiPanel.AsciiPanel;

public enum Tile {
	
    FLOOR((char)177, AsciiPanel.black, false),
    VOID((char)250, AsciiPanel.white, false),
    WALL((char)177, AsciiPanel.white, true),
    DOOR((char)177, AsciiPanel.red, false); // need open and closed door
 
    private char glyph;
    private Color color;
    private boolean solid;
    
    Tile(char glyph, Color color, boolean solid){
        this.glyph = glyph;
        this.color = color;
        this.solid = solid;
    }
    
    public char glyph(){
    	return glyph;
    }
    
    public Color color(){
    	return color;
    }
    
    public boolean solid(){
    	return solid;
    }
    
}
