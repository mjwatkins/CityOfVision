package com.watkinstechpro.vision.mapping;

import java.time.LocalDate;

public class LocalDater {
	LocalDate date;
	
	public LocalDater(String date, String time){
		String dateStr;
		int year, month, day;
		
		String timeStr;
		String hrs, minutes, seconds;
		
		String[] dateParts = splitDate(date);
		String[] timeParts = splitDate(time);
		
		if(dateParts != null){
			dateStr = dateParts[0];
			
			String[] dateStrParts = dateStr.split("-");
			if(dateStrParts.length != 3){
				System.out.println("Error, date wrong format: "+dateStr);
			}
			else{
				 year = Integer.parseInt(dateStrParts[0]);
				 month = getMonth(dateStrParts[1]);
				 day = Integer.parseInt(dateStrParts[2]);
			}
		}
		
		if(timeParts != null){
			timeStr = timeParts[1].substring(0, 5);
		}
		
	}
	
	private int getMonth(String regMonth){
		if(regMonth.startsWith("0")){ // Single Digit
			regMonth = regMonth.substring(1);
		}
		
		//int regMonthNum = Integer.parseInt(s)
		
		return -1;
	}
	private String[] splitDate(String dateOrTime){
		if(dateOrTime == null) return null;
		
		dateOrTime = dateOrTime.toUpperCase();
		return dateOrTime.split("T");
	}
}
