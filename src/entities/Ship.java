package entities;

import java.util.ArrayList;

public class Ship {

	private String name;
	private float hullDamage;
	private float shieldLevel;
	
	public Ship(){
		name = "exquisition";
		hullDamage = 0;
		shieldLevel = 100;
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
