package modules;

/**
 * The Reactor class
 * @author stanners
 *
 * The reactor class will have some exciting, unique attributes. Reactors have a maximum power output 
 * and a current power output. If maximum power draw is equal to current power draw, the operating 
 * percentage will be 100%. Reactors however are nowhere near as forgiving when it comes to working 
 * over capacity.
 * 
 */

public class Reactor extends Module {

	private float maximumPowerDraw; // measured in megawatts or jiggawatts
	private float currentPowerDraw;
	private String fuelType; // again, maybe use int later. i haven't defined them yet though (TODO)...
	private float maximumFuelLevel;
	private float currentFuelLevel;
	
}
