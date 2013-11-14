package components;

import java.awt.Color; // more of trysten's code
import asciiPanel.AsciiPanel;

public enum Tile {
	
    // SHIP VIEW
	FLOOR((char)177, 	AsciiPanel.black, 			false),
    VOID((char)250, 	AsciiPanel.white, 			false),
    DOOR((char)177, 	AsciiPanel.black, 			false),
    SHUTDOOR((char)177, AsciiPanel.red, 			true),
    WALL((char)177, 	AsciiPanel.white, 			true),
    
    // SYSTEM VIEW
    MYSHIP((char)38, 	AsciiPanel.green, 			false),
    ALLYSHIP((char)38, 	AsciiPanel.blue, 			false),
    ENEMYSHIP((char)38, AsciiPanel.red, 			false);
 
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
