package com.watkinstechpro.vision.mapping;

public enum IncidentType {
	SIDEWALK_REQUEST, ACCIDENT, ILLEGAL_DUMPING; 
	
	public static String toString(IncidentType type) {
		String typeName = ""; 
		
		switch(type) {
		
		case SIDEWALK_REQUEST: 
			typeName = "Sidewalk Request";
		case ACCIDENT: 
			typeName = "Accident"; 
		case ILLEGAL_DUMPING: 
			typeName = "ILLEGAL_DUMPING"; 
			
		}
		
		return typeName; 
	}
	
	public static IncidentType getIncidentType(String type){
		return valueOf(type);
	}
}
