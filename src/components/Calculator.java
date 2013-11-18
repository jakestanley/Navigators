package components;

import modules.WarpGenerator;
import entities.Ship;

public class Calculator {
	
	public static String calculateJourneyTime(Ship ship, float distance){
		String journeyString = "";
		WarpGenerator warp = null;
		for(int i = 0; i < ship.moduleList.size(); i++){
			if(ship.moduleList.get(i).getModuleName() == "warp"){
				warp = (WarpGenerator) ship.moduleList.get(i);
			}
		}
		if(warp == null){
			journeyString = "This ship does not have a warp generator installed";
		} else {
			if(warp.getCurrentOperatingPercentage() != 0){
				float maxWarpSpeed = warp.getMaxWarpSpeed();
				float currentOperatingPercentage = warp.getCurrentOperatingPercentage();
				float currentWarpSpeed = (maxWarpSpeed / 100) * currentOperatingPercentage;
				float journeyTime = distance / currentWarpSpeed;
				journeyString = "Dist: " + distance +  
					"ly. Mx: " + maxWarpSpeed + 
					"ly/h. Perc: " + currentOperatingPercentage + 
					"%. Act: " + currentWarpSpeed + 
					"ly/h. ETA: " + journeyTime + 
					" hours.";
			} else {
				journeyString = "Cannot work out a journey time as the power is set to 0%";
			}
		}
		return journeyString;
	}
	
}
