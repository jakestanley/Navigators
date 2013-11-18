package interfaces;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import components.Calculator;
import components.Interpreter;
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
		terminal.write("Navigators", 1, 1); // TODO 
		terminal.write("Commander OS 0.12", 1, 2);
		terminal.write("System ready", 1, 3);
		terminal.write("Hull damage: " + Game.ship.getHullDamage() + "%", 1, 5);
		terminal.write("Shield charge: " + Game.ship.getShieldLevel() + "%", 1, 6);
		terminal.write("Location X: " + Game.ship.getX(), 24, 5);
		terminal.write("Location Y: " + Game.ship.getY(), 24, 6);
		terminal.write("Location Z: " + Game.ship.getZ(), 24, 7);
        if(textPrompt){
        	terminal.write(promptText + userInput + "_", 1, 20);
        } else {
        	terminal.write(promptText, 1, 20);
        }
        drawModuleList(terminal, 10);
        terminal.write(Calculator.calculateJourneyTime(Game.ship, 1000), 1, 8);
    }
 
    public Screen respondToUserInput(KeyEvent key) { // TODO fix this up. it works, but it reads like shit.
        switch (key.getKeyCode()){
        case KeyEvent.VK_ENTER: // if user prompt key
        	if(textPrompt){ // TODO this can be simpler and much more readable, etc, etc
        		Interpreter.executeCommand(Game.ship, userInput);
        		userInput = "";
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
        	} else { // use letters as usual
        		if(newLetter == "r".charAt(0)){ // TODO make this not ugly...
        			return new CrewScreen();
        		} else if(newLetter == "p".charAt(0)){
        			return new ShipMap(37, 19);
        		} else if(newLetter == "s".charAt(0)){
        			return new SystemMap(100, 100);
        		}
        	}
        	break;
        }
        return this;
    }

	@Override
	public void drawViewBar(AsciiPanel terminal) {
		int line = Game.viewBarLine;
		terminal.write(" (M)AIN ", 1, line, terminal.brightWhite, terminal.brightGreen); // TODO intelligent spacing
		terminal.write(" C(R)EW ", 10, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" MA(P) ", 19, line, terminal.brightWhite, terminal.red); // TODO intelligent spacing
		terminal.write(" (S)YSTEM ", 27, line, terminal.brightWhite, terminal.red);
	}
	
	public void drawModuleList(AsciiPanel terminal, int startLine) {
		terminal.write("Installed modules: ", 1, startLine);
		for(int i = 0; i < Game.ship.moduleList.size(); i++){
			terminal.write(Game.ship.moduleList.get(i).getModuleName(), 1, i + startLine + 1);
		}
	}

}
