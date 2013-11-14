package interfaces;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import begin.Game;
import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {
	
	private String promptText;
	private String userInput = "";
	private boolean textPrompt = false;
	
	public PlayScreen(){
		promptText = Game.player.getName() + "@" + Game.ship.getName() + " scsh $ ";
	}

	public void displayOutput(AsciiPanel terminal) { // TODO split these writes into functions
		drawViewBar(terminal);
		terminal.write("Navigators", 1, 1);
		terminal.write("Commander OS 0.12", 1, 2);
		terminal.write("System ready", 1, 3);
		terminal.write("Hull damage: " + Game.ship.getHullDamage() + "%", 1, 5);
		terminal.write("Shield charge: " + Game.ship.getShieldLevel() + "%", 1, 6);
        if(textPrompt){
        	terminal.write(promptText + userInput + "_", 1, 20);
        } else {
        	terminal.write(promptText, 1, 20);
        }
    }
 
    public Screen respondToUserInput(KeyEvent key) { // TODO fix this up. it works, but it reads like shit.
        switch (key.getKeyCode()){
        case KeyEvent.VK_ENTER: // if user prompt key
        	if(textPrompt){ // TODO this can be simpler and much more readable, etc, etc
        		processUserInput(); // global?
        		textPrompt = false;
        		System.out.println("User input now false");
        	} else {
        		textPrompt = true;
        		System.out.println("User input now true");
        	}
        	break;
        case KeyEvent.VK_BACK_SPACE:
        	if(textPrompt){
        		if(userInput.length() > 0){
        			userInput = userInput.substring(0, userInput.length()-1);
        		}
        	}
        	break;
        default:
        	char newLetter = key.getKeyChar();
        	if(textPrompt){
        		if((Character.isLetterOrDigit(newLetter) || Character.isSpaceChar(newLetter)) && userInput.length() < 40){
        			userInput = userInput + key.getKeyChar(); // hope this works
            		System.out.println("Added to user input string");
        		} else {
        			System.out.println("Ignoring last input as it wasn't an acceptable char");
        		}
        	} else {
        		if(newLetter == "r".charAt(0)){ // TODO make this not ugly...
        			System.out.println("r was pressed");
        			return new CrewScreen();
        		} else if(newLetter == "p".charAt(0)){
        			System.out.println("i was pressed");
        			return new RogueMap();
        		}
        		// use letters as usual
        	}
        	break;
        }
        return this;
    }
    
    public void processUserInput(){
    	ArrayList<String> commands = new ArrayList<String>();
    	System.out.println("Processing user input string: " + userInput);
		for(String word: userInput.split(" ")){ // splits by space
			commands.add(word);
		}
    	Game.ship.executeCommand(commands);
    	System.out.println("Clearing...");
    	userInput = "";
    }

	@Override
	public void drawViewBar(AsciiPanel terminal) {
		int line = Game.viewBarLine;
		terminal.write(" (M)AIN ", 1, line, terminal.brightWhite, terminal.brightGreen); // TODO intelligent spacing
		terminal.write(" C(R)EW ", 10, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" MA(P) ", 19, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
	}

}
