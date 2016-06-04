/**
 * 
 */
package com.watkinstechpro.vision.mapping;

import java.util.ArrayList;

/**
 * @author mjwatkins
 *
 */
public class MapData {

	
	private ArrayList<Incident> incidents;
	private ArrayList<HotSpot> hotSpots;
	
	
	public MapData () {
		this.incidents = new ArrayList<Incident>();
		this.hotSpots = new ArrayList<HotSpot>();
	}
	
	
	public void addIncident(Incident incident){
		this.incidents.add(incident);
	}
	
	public void  addHotSpot(HotSpot spot) {
		this.hotSpots.add(spot);
	}


	/**
	 * @return the incidents
	 */
	public ArrayList<Incident> getIncidents() {
		return incidents;
	}


	/**
	 * @return the hotSpots
	 */
	public ArrayList<HotSpot> getHotSpots() {
		return hotSpots;
	}
	
	
	public String toString() {
		StringBuilder info = new StringBuilder(); 
		for (Incident i : this.incidents){
			info.append(i.toString());
		}
		for (HotSpot h : this.hotSpots){
			info.append(h.toString()); 
		}
		return info.toString(); 
	}
}

