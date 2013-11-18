package modules;

public class WarpGenerator extends Module {

	private float maxWarpSpeed; // arbitrary units per hour or minute?
	private float currentWarpSpeed;
	private float targetX, targetY, targetZ; // need to check target doesn't collide with anything.
	
	public WarpGenerator(float maxWarpSpeed){ // add "float energyUsage" (later)
		super();
		this.moduleName = "warp";
		this.maxWarpSpeed = maxWarpSpeed;
//		this.energyUsage = energyUsage; // TODO add back in / work out - later
	}
	
	public void setTarget(float x, float y, float z){ // maybe boolean to return false if invalid target
		this.targetX = x;
		this.targetY = y;
		this.targetZ = z;
	}
	
	public float getTargetX(){
		return targetX;
	}
	
	public float getTargetY(){
		return targetY;
	}
	
	public float getTargetZ(){
		return targetZ;
	}
	
	public float getMaxWarpSpeed(){
		return maxWarpSpeed;
	}
	
}
