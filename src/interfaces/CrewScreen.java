package interfaces;

import java.awt.event.KeyEvent;

import entities.Crew;
import asciiPanel.AsciiPanel;

public class CrewScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		terminal.write("Crew", 1, 1);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printCrewStats(AsciiPanel terminal, Crew member){
		// TODO populate this with terminal writes
	}
	
	public void printCrewList(){
		// TODO populate based on crew list
	}

}
