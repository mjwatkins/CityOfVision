/**
 * 
 */
package com.watkinstechpro.vision.mapping;

/**
 * @author kmjwatkins
 *
 */
public class Location {

	private int streetNum;
	private String streetName;
	private String cityName; 
	private String state;
	private int zipCode; 
	private double lat;
	private double lon; 
	
	public Location(int num, String street, String city, String state){
		this.streetNum = num;
		this.streetName = street;
		this.cityName = city;
		this.state = state; 
				
	}

	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public void determineLatLon() {
		// add code for google request...
	}
}
