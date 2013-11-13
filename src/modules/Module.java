package modules;

/**
 * The Module class
 * @author stanners
 *
 * This is the super class of all ship modules. There are some modules that are mandatory 
 * for a ship's operation and there are some that aren't. A reactor is a given, ships must 
 * have some kind of power source or they just cannot run. The reactor is usually positioned 
 * central to the ship, but I would like to give users the ability to move it, or even 
 * remove the reactor altogether. Great problems will ensue if they do, but I would like the 
 * freedom to be there. Anyway...
 * 
 * All modules have a certain size and certain central points, to be used by the map building 
 * algorithm. All modules will have a volume, measured in cubic metres, which will be used to 
 * calculate the time it takes to pressurise or depressurise a module.
 * 
 * Each module will have a float representing the various gases (or nothings, i.e vacuum) in 
 * the atmosphere. These must always add up to no more or less than 100%, give or take by a 
 * few decimal places. Science James might be able to help me with this.
 * 
 * I have an idea that also an atmosphere could consist of liquids such as water or magma, but 
 * I'm not sure if this will work in the same percentage kind of a way. I need some science help.
 *
 */

public class Module { // i'm unsure... should this be an interface or a class?
	
	// GASES
	protected float oxygenPercentage; // healthy to humans
	protected float carbonDioxidePercentage;
	protected float carbonMonoxidePercentage; // deadly to humans
	protected float nitrogenPercentage;
	protected float hydrogenPercentage;
	
	// NON-GASES
	protected float magmaPercentage;
	protected float waterPercentage; // interferes greatly with electronics. this is liquid water.
	protected float vacuumPercentage;

}
