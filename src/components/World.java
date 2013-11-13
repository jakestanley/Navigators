package components;

import java.awt.Color;

public class World {
    private Tile[][] tiles;
    private int width;
    private int height;
    
    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }
    
    public int getWidth(){
    	return width; 
    }
    
    public int getHeight(){
    	return height;
    }
    
    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.VOID;
        else
            return tiles[x][y];
    }
    
    public char glyph(int x, int y){
        return tile(x, y).glyph();
    }
    
    public Color color(int x, int y){
        return tile(x, y).color();
    }
    
}
