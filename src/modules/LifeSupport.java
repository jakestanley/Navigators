package modules;

/**
 * The LifeSupport class 
 * @author stanners
 *
 * Life support is important to living crew members. Many will likely die without it.
 * The completed life support will at least have the following abilities, outlined 
 * in this class documentation. The ship will have an oxygen capacity and an oxygen 
 * level. Modules can be vented, but this will reduce the available oxygen (or total 
 * oxygen level). Carbon dioxide expelled from carbon based lifeforms will be scrubbed, 
 * but if the life support module isn't functioning properly, this will create 
 * eventually lead to a toxic atmosphere. I have an idea that some races of crew members 
 * will be able to breathe carbon dioxide and expel oxygen, leading to a potential energy 
 * saving on scrubbers when working with oxygen breathing lifeforms.
 * 
 * Life support can be used as weapon. It can be hacked to fill entire modules with gases 
 * poisonous to certain races and could even prevent invaders from entering ships, as 
 * it could be used as a defensive measure against certain races of invaders. For example, 
 * if you had a completely nitrous oxide (not sure about this) breathing crew and you were 
 * invaded by an oxygen breathing race, they (unless they brought the correct equipment) 
 * would die of oxygen deprivation if little or no oxygen was in the ship's atmosphere.
 * 
 * I will do some science research, but modules will hopefully have percentages of various 
 * gases in the atmosphere, that will change dynamically depending on air pressure, when 
 * doors are opened, etc, etc. Doors can be airlocked to prevent crew or enemies from 
 * entering them, but also to prevent crew death if you are venting a room or jettisoning 
 * a module. IDEAS IDEAS IDEAS!
 * 
 * The main mission of life support is to provide comfortable living conditions for the 
 * crew. It should be possible to have crew of diverse races that share incompatible 
 * living conditions, if they wear protective equipment when working together, or work 
 * on separate parts of the ship that have the appropriate life support conditions for 
 * their survival. Ideally, also, to prevent atmospheric depressurisation/imbalance, etc, 
 * neutral atmosphere airlocks should ideally separate areas of the ship between living 
 * conditions. It takes less time to readjust the atmosphere of a small room than it does 
 * a large one. 
 * 
 * Life support needs to contain tanks that store (ideally) surplus oxygen (or whatever the 
 * crew memberes respire), in the event of depressurisation. If the reserves are low and the 
 * ship cannot be appropriately pressurised, some areas of the ship may have to be shut down 
 * in order to keep the ship habitable. Crew members, depending on race or current 
 * equipment may take damage in depressurised environments. The damage will vary according 
 * to the level of depressurisation. Minor depressurisation may not cause harm, but long term 
 * exposure may cause depressurisation sickness (TODO crew illnesses). 
 *
 */

public class LifeSupport extends Module {

	private float oxygenCapacity;
	private float oxygenLevel;
	
}
