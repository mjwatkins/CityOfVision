/**
 * 
 */
package com.watkinstechpro.vision.mapping;

import java.util.HashMap;

/**
 * @author kwatkins
 *
 */
public class HotSpot {

	private IncidentType type;
	private double latCenter;
	private double longCenter; 
	private double radius; 
	private HashMap<Location,Integer> frequencyMap; 
	
	public HotSpot() {
		this.latCenter = 0; 
		this.longCenter = 0; 
		this.radius = 0; 
		this.frequencyMap = new HashMap<Location, Integer>(); 
	}

	/**
	 * @return the type
	 */
	public IncidentType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(IncidentType type) {
		this.type = type;
	}

	/**
	 * @return the latCenter
	 */
	public double getLatCenter() {
		return latCenter;
	}

	/**
	 * @param latCenter the latCenter to set
	 */
	public void setLatCenter(double latCenter) {
		this.latCenter = latCenter;
	}

	/**
	 * @return the longCenter
	 */
	public double getLongCenter() {
		return longCenter;
	}

	/**
	 * @param longCenter the longCenter to set
	 */
	public void setLongCenter(double longCenter) {
		this.longCenter = longCenter;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the frequencyMap
	 */
	public HashMap<Location, Integer> getFrequencyMap() {
		return frequencyMap;
	}

	/**
	 * @param frequencyMap the frequencyMap to set
	 */
	public void setFrequencyMap(HashMap<Location, Integer> frequencyMap) {
		this.frequencyMap = frequencyMap;
	}
	
	public void addLocation(Location loc) {
		int count;
		
		if (this.frequencyMap.containsKey(loc)) {
			count = this.frequencyMap.get(loc);
			this.frequencyMap.put(loc, ++count);
		} else {
			this.frequencyMap.put(loc, 1); 
		}
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder(); 
		info.append("Hot Spot, ");
		info.append(this.type + ","); 
		info.append(this.latCenter + ",");
		info.append(this.longCenter + "\n");
		for (Location l : this.frequencyMap.keySet()) {
			info.append("HSL , ");
			info.append(l.getLat() + "," + l.getLon() + ",");
			info.append(this.frequencyMap.get(l) + "\n");
		}
		info.append("HSEnd \n"); 
		return info.toString(); 
		
	}
	
	
	
}
