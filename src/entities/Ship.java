package entities;

import java.util.ArrayList;

import modules.Module;

public class Ship {

	private String name;
	private float hullDamage;
	private float shieldLevel;
	private float x, y, z; // improve.
	private ArrayList<Crew> crewList; // TODO tidy this up
	private ArrayList<Module> moduleList;
	
	public Ship(String name){
		this.name = name;
		hullDamage = 0;
		shieldLevel = 100;
		crewList = new ArrayList<Crew>();
		moduleList = new ArrayList<Module>();
	}
	
	public String getName(){
		return name;
	}
	
	public String executeCommand(ArrayList<String> commands){
		String command = commands.get(0).toLowerCase();
		if(command.equals("attack")){
			this.damageHull(1);
		} else if(command.equals("repair")){
			this.repairHull(1);
		} else if(command.equals("quit")){
			System.exit(0); 
			// TODO deal with this in a better way. 
			// TODO the ship class shouldn't handle command interpretation and definitely not exits
		}
		return null;
	}
	
	public float getHullDamage(){
		return hullDamage;
	}
	
	public float getShieldLevel(){
		return shieldLevel;
	}
	
	public void damageHull(float damage){
		if((hullDamage + damage) > 100){
			hullDamage = 100;
		} else {
			hullDamage = hullDamage + damage;
		}
	}
	
	public void repairHull(float repair){
		if((hullDamage - repair) < 0){
			hullDamage = 0;
		} else {
			hullDamage = hullDamage - repair;
		}
	}
	
}
