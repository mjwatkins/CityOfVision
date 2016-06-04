package com.watkinstechpro.vision.mapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {
	
	private ArrayList<Incident> incidents;
	
	public CSVParser (String filename) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			
			String[] parts = line.split(",");
			String[] address = parts[4].split(" ");
			Incident incident = new Incident(Integer.parseInt(address[0]), address[1], parts[6], "Indiana", 0, parts[9],
			parts[2]);
			//(int num, String street, String city, String state, int severity, String dateStr,
			//String type)
			this.incidents.add(incident);
			System.out.println(incident.toString());
		}
	}
}
