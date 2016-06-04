/**
 * 
 */
package com.watkinstechpro.vision.mapping;

import java.time.LocalDate;

/**
 * @author mjwatkins
 *
 */
public class Incident {
	
	private Location loc;
	private int severity;
	private LocalDate date;
	private IncidentType type;
	
	
	public Incident(Location loc, int severity, LocalDate date,
			IncidentType type) {
		super();
		this.loc = loc;
		this.severity = severity;
		this.date = date;
		this.type = type;
	}
	
	public Incident(int num, String street, String city, String state, int severity, String dateStr,
			String type) {
		// K added
		this(new Location(num, street, city, state), severity, new LocalDater(dateStr).getDate(), IncidentType.getIncidentType(type));
	}
	


	/**
	 * @return the loc
	 */
	public Location getLoc() {
		return loc;
	}


	/**
	 * @param loc the loc to set
	 */
	public void setLoc(Location loc) {
		this.loc = loc;
	}


	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}


	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}


	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Incident, "); 
		info.append(this.loc.getLat() + ",");
		info.append(this.loc.getLon() + ",");
		info.append(IncidentType.toString(this.type)); 
		return info.toString(); 
	}
	
}
