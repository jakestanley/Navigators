package components;

import java.util.ArrayList;

import entities.Ship;
import modules.WarpGenerator;
import begin.Game;

public class Interpreter {
	
	public static ArrayList<String> commands;

	public static void executeCommand(Ship ship, String userInput){
		explodeUserInput(userInput);
		int index = 0;
		String command = commands.get(index).toLowerCase();
		if(command.equals("attack")){
			ship.damageHull(1);
		} else if(command.equals("repair")){
			ship.repairHull(1);
		} else if(command.equals("quit") || command.equals("close") || command.equals("exit")){ // if close
			System.exit(0); 
			// TODO deal with this in a better way.
		} else if(command.equals("install")){
			index++;
			command = commands.get(index);
			if(command.equals("warp")){
				// installing warp drive.
				index++;
				float maxWarpSpeed = Float.parseFloat(commands.get(index));
				ship.moduleList.add(new WarpGenerator(maxWarpSpeed));
			}
		} else if(command.equals("set")){
			executeSet(ship);
		}
	}
	
	private static void explodeUserInput(String userInput){
		commands = new ArrayList<String>();
    	System.out.println("Processing user input string: " + userInput);
		for(String word: userInput.split(" ")){ // splits by space
			commands.add(word);
		}
	}
	
	private static void executeInstall(Ship ship){ // testing only really
		
	}
	
	private static void executeSet(Ship ship){
		int index = 1;
		String command = commands.get(index);
		if(command.equals("warp")){
			// installing warp drive.
			index++;
			float perc = Float.parseFloat(commands.get(index));
			ship.getWarpGenerator().setOperatingPercentage(perc);
		}
	}

}
