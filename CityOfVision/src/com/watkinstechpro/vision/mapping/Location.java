/**
 * 
 */
package com.watkinstechpro.vision.mapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

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
		// add code for google request....
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + streetNum;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Location))
			return false;
		Location other = (Location) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (streetNum != other.streetNum)
			return false;
		return true;
	}

	public static double[] convertAddressToLatLon(String address) {
		double[] latlon = new double [2];
		String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";
		String apiKey = "&key=AIzaSyCOjGi_6QfMOMkLo2uLlHzqb9dw7K0uhmo";
		String encodedAddress = address.replace(" ","+"); 
		URL webUrl = null; 
		HttpURLConnection conn = null; 
		
		try {
			webUrl = new URL(baseUrl + encodedAddress + apiKey);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			conn = (HttpURLConnection) webUrl.openConnection();
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		StringBuilder geoInfoString = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		String data = null; 
		
		do {
			try {
				data = reader.readLine();
				if (data != null) {
					geoInfoString.append(data); 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}while (data != null);
		
		JSONObject jsonFile = new JSONObject(geoInfoString); 
		
		return latlon; 
		
	}
	
	
	


}
