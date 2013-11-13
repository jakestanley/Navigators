package components;

import java.awt.Color; // more of trysten's code
import asciiPanel.AsciiPanel;

public enum Tile {
    FLOOR((char)177, AsciiPanel.black),
    VOID((char)250, AsciiPanel.white),
    WALL((char)177, AsciiPanel.white),
    DOOR((char)177, AsciiPanel.red);
 
    private char glyph;
    public char glyph() { return glyph; }
 
    private Color color;
    public Color color() { return color; }
 
    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
}
