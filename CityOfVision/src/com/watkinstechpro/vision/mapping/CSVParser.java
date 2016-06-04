package com.watkinstechpro.vision.mapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVParser {
	
	public CSVParser (String filename) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			
			String[] parts = line.split(",");
			Incident incident = new Incident(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5],
			parts[6]);
			
			System.out.println(incident.toString());
		}
	}
}
