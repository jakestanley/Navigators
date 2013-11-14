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
 * I'm not sure if this is going to be a part of modules or a future utilities/tools component, 
 * but mechanical crew members (i.e robots) will be more proficient with equipment manufactured 
 * by their manufacturer. Kind of like how Apple products work better with one another. In a 
 * similar way, I kind of like the idea that some cheaper brands will break easily, will be 
 * difficult for low proficiency crew members to use, or other problems will arise from them, 
 * prompting users to consider what they can get for their money. Maybe there could be a reviews 
 * system??? i will use brands in modules for now. Locking a module should ideally lock all doors 
 * surrounding the module.
 * 
 * All modules have an operating percentage and energy usage factor. At 100% capacity, the module 
 * will use the exact specified energy usage. This will increase or decrease depending on the 
 * percentage. The energy usage factor is used as fuel usage for reactors? Current operating %age
 * can be increased well over 100%, however performance becomes unstable above 100% and prone to 
 * failure much more quickly. Exploding modules can harm crew members, depressurise the module or 
 * in some cases destroy entire ships. An exploding reactor pretty much means instant death for 
 * an entire crew.
 * 
 * Room temperature is altered by life support, increased by module operating heat, decreased by vacuum 
 * exposure (except in star/hot planet vicinity), coolant, water, ice, etc.
 *
 * TODO answer these questions: Should modules have coolant? Technical: Is some form of identification 
 * necessary? Some ships will have more than two of a kind of module. How will modules map to the ship view? 
 * Ships should be able to be drawn from a ship object. That's going to be a fun function to write :)
 *
 */

public class Module { // i'm unsure... should this be an interface or a class?
	
	protected String brand; // will probably use an int later. not sure... TODO
	protected float currentOperatingPercentage; // anything over 100% will be risky - calculated by subclass.
	protected float energyUsage; // this is the energy usage at 100% operation
	protected float roomTemperature; // measured in celsius
	protected float condition; // max 100%. directly affects performance.
	
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
