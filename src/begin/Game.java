package begin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import interfaces.ShipMap;
import interfaces.Screen;
import interfaces.StartScreen;

import javax.swing.JFrame;

import entities.Crew;
import entities.Player;
import entities.Ship;
import asciiPanel.AsciiPanel;
 
public class Game extends JFrame implements KeyListener { // implement applet later 

	private static final long serialVersionUID = 8475393520489155511L;
	public static final int viewBarLine = 23;
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
//        screen = new StartScreen(); // for regular testing
        screen = new ShipMap(37, 19); // for map testing
        addKeyListener(this);
        repaint();
    }
    
    public void initialiseShip(){
    	ship = new Ship("exquisition");
    	ship.addCrewMember(new Crew(21, "Jake", "Stanley"));
    	ship.addCrewMember(new Crew(22, "Jamie", "Hall"));
    	ship.addCrewMember(new Crew(21, "Matt", "Brown"));
    	ship.addCrewMember(new Crew(24, "James", "Birkett"));
    	ship.addCrewMember(new Crew(19, "Mark", "Bradley"));
    	ship.addCrewMember(new Crew(49, "Andy", "Wray"));
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