package com.watkinstechpro.vision.mapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class LocalDater {
	LocalDate date;
	LocalTime time;
	
	public LocalDater(String date, String time){
		retrieveDate(date);
		retrieveTime(time);
	}
	
	public LocalDater(String year, String month, String day){
		retrieveDate(year+"-"+month+"-"+day);
	}
	
	public LocalDater(String dateAndTime){
		this(dateAndTime.split("T")[0], null); // ignore time
	}

	public LocalDate getDate(){
		return date;
	}
	
	public LocalTime getTime(){
		return time;
	}
	private void retrieveTime(String time){
		String timeStr;
		String hrs, minutes, seconds;
		
		String[] timeParts = splitDate(time);
		
		if(timeParts != null){
			timeStr = timeParts[1].substring(0, 5);
			
			String[] timeStrParts = timeStr.split(":");
			String hours = timeStrParts[0];
			String min = timeStrParts[1];
			if(hours.startsWith("0"))
				hours = hours.substring(1);
			
			if(min.startsWith("0"))
				min = min.substring(1);
			
			this.time = LocalTime.of(Integer.parseInt(hours), Integer.parseInt(min));
		}
	}
	
	private void retrieveDate(String date) {
		String dateStr;
		int year, day;
		Month month;

		String[] dateParts = splitDate(date);
		
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
				 
				 this.date = LocalDate.of(year, month, day);
			}
		}
	}

	private Month getMonth(String regMonth){
		if(regMonth.startsWith("0")){ // Single Digit
			regMonth = regMonth.substring(1);
		}
		
		int regMonthNum = Integer.parseInt(regMonth);
		
		return Month.of(regMonthNum);
	}
	
	private String[] splitDate(String dateOrTime){
		if(dateOrTime == null) return null;
		
		dateOrTime = dateOrTime.toUpperCase();
		return dateOrTime.split("T");
	}
	
	public String toString(){
		if (date == null) return null;
		return date.toString();
	}
	

	
//	public static void main(String[] args){
//		LocalDater ld = new LocalDater("2016-06-04T12:30:00000.00Z");
//		System.out.println(ld);
//	}
}
