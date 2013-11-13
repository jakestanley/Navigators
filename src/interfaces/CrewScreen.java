package interfaces;

import java.awt.event.KeyEvent;

import begin.Game;
import entities.Crew;
import asciiPanel.AsciiPanel;

public class CrewScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		terminal.write("Crew", 1, 1);
		printCrewList(terminal);
		printCrewStats(terminal, Game.ship.crewList.get(0));
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		Screen screen = this;
		switch (key.getKeyCode()){
        case KeyEvent.VK_M:
        	screen = new PlayScreen();
		}
		return screen;
	}
	
	public void printCrewStats(AsciiPanel terminal, Crew member){
		terminal.write("First name: " + member.getFirstName(), 1, 3);
		terminal.write("Last name: " + member.getLastName(), 1, 4);
		terminal.write("Age: " + member.getAge(), 1, 5);
	}
	
	public void printCrewList(AsciiPanel terminal){
		// TODO populate based on crew list
		for(int i = 0; i < Game.ship.crewList.size(); i++){
			terminal.write(Game.ship.crewList.get(i).getSmartName(), 30, i + 1);
		}
	}

}
