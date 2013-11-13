package entities;

/*
 *  The Crew class - Jacob Stanley, 2013 
 * 
 *  I would like age to be dynamic, with a date of birth, etc. I would prefer individual proficiencies, 
 *  as opposed to a set skill level for everything, but I'll work on that when I've worked out what 
 *  proficiencies will be required. Height and weight will be measured in metric, because any other 
 *  system is extremely archaic. Later, if I decide to stick with languages, we'll use an integer array. 
 *  I have the idea that crew members who do not share a common language will be unable to converse. 
 *  
 *  The way I imagine morale to work is that there is positive, neutral and negative morale. A long 
 *  running idea with Navigators/SC has been that crew members with low morale will have the potential 
 *  to defer to enemy players. A new idea I have is that if crew members work with low morale crew 
 *  members, their morale level will be reduced, however the formula should work in reverse. This will 
 *  encourage players to more proactively assign jobs and locations to their crew members. A positive 
 *  morale will make a crew member perform tasks much more proficiently, but only based on the level of  
 *  negative or positive morale. Activities, such as winning battles, hosting parties, giving crew pay 
 *  rises, amongst other things should boost morale. 
 *  
 *  Elderly crew members have a higher risk of mortality, and illness, but will be more experienced, 
 *  resulting in a naturally high proficiency. Health will reduced more quickly in older people, but if 
 *  they are kept out of danger and work in healthy atmospheres, with good healthcare and maybe 
 *  protective equipment, they will last for a long time (again, encouraging crew management proactivity). 
 *  Another slight downside is that elderly crew members will commands much higher salaries.
 *  
 */

public class Crew {

	private int gender;
	private int age; // this will be in years
	private int skillLevel;
	private int morale;
	private float weight; // measured in kilograms, of course
	private float height; // and metres here [metric ftw]
	private float health; // TODO add diseases, ailments and disabilities, etc??
	private String firstName;
	private String lastName;
	private String ethnicity; // hmmm
	private String language; // we'll use integers later on, when i've fleshed this out.
	private String currentTask; // not sure about this.
	
	public Crew(int age, String firstName, String lastName){
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getSmartName(){
		return lastName + ", " + firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}
	
}
