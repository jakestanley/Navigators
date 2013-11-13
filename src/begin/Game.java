package begin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import interfaces.RogueMap;
import interfaces.Screen;
import interfaces.StartScreen;

import javax.swing.JFrame;

import entities.Crew;
import entities.Player;
import entities.Ship;
import asciiPanel.AsciiPanel;
 
public class Game extends JFrame implements KeyListener { // implement applet later 

	private static final long serialVersionUID = 8475393520489155511L;
	public static Ship ship;
	public static Player player;
    private AsciiPanel terminal;
    private Screen screen;
 
    public Game(){
        super("Navigators"); // name of window - can this be run in a game window?
        initialiseShip();
        player = new Player();
        terminal = new AsciiPanel();
        add(terminal); // what does this do?
        pack(); // what does this do?
//        screen = new StartScreen(); // for map testing, TODO uncomment
        screen = new RogueMap();
        addKeyListener(this);
        repaint();
    }
    
    public void initialiseShip(){
    	ship = new Ship();
    	ship.crewList.add(new Crew(21, "Jake", "Stanley"));
    	ship.crewList.add(new Crew(22, "Jamie", "Hall"));
    	ship.crewList.add(new Crew(21, "Matt", "Brown"));
    	ship.crewList.add(new Crew(24, "James", "Birkett"));
    	ship.crewList.add(new Crew(19, "Mark", "Bradley"));
    	ship.crewList.add(new Crew(49, "Andy", "Wray"));
    }
    
    public void repaint(){
    	terminal.clear();
    	screen.displayOutput(terminal);
    	super.repaint();
    }
    public void keyPressed(KeyEvent e){
    	screen = screen.respondToUserInput(e);
    	repaint();
    }
    
    public void keyReleased(KeyEvent e){
    	
    }
    
    public void keyTyped(KeyEvent e){
    	
    }

}