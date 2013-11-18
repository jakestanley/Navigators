package entities;

import java.util.ArrayList;

import begin.Game;
import modules.Module;
import modules.Bridge;
import modules.LifeSupport;
import modules.Reactor;
import modules.WarpGenerator;

/**
 * The Ship class
 * @author stanners
 * 
 */

public class Ship {

	private String name;
	private float hullDamage;
	private float shieldLevel;
	private float x, y, z; // improve.
	public ArrayList<Crew> crewList; // TODO tidy this up
	public ArrayList<Module> moduleList;
	
	public Ship(String name){
		x = 0;
		y = 0;
		z = 0;
		this.name = name;
		hullDamage = 0;
		shieldLevel = 100;
		crewList = new ArrayList<Crew>();
		moduleList = new ArrayList<Module>();
		
		// init modules
		moduleList.add(new Reactor());
		moduleList.add(new LifeSupport());
		moduleList.add(new Bridge());
//		moduleList.add(new WarpGenerator(100));
	}
	
	public String getName(){
		return name;
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
	
	public void addCrewMember(Crew crew){
		crewList.add(crew);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getZ(){
		return z;
	}
	
	public WarpGenerator getWarpGenerator(){
		WarpGenerator warper = null;
		for(int i = 0; i < moduleList.size(); i++){
			if(moduleList.get(i).getModuleName().equals("warp")){
				warper = (WarpGenerator) moduleList.get(i);
			}
		}
		return warper;
	}
	
}
