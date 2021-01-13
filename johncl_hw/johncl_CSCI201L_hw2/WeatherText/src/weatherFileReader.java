import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class weatherFileReader 
{
	public static void main(String [] args) 
	{
		ArrayList<weatherObj> cities = new ArrayList<weatherObj>();
		Scanner scan = new Scanner(System.in);
		Boolean readFile = false;
		String error = "";
		int testInt = -1;
		float testFloat = -1.0f;
		Boolean except = false;
		
		while(!readFile) {
			System.out.print("What is the name of the weather file? ");
			String filename = scan.nextLine();
			String conditions = "";
			
			error = "";
			
			try {
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();
				while(line != null) {
					String[] data = line.split("\\|");
					if(data.length < 16) {
						error = "There are not enough parameters on line '" + line + "'.";
						throw new IOException();
					}
					try{
						testInt = Integer.parseInt(data[7]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[7] + "' to an int.";
						throw new IOException();
					}
					try{
						testInt = Integer.parseInt(data[8]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[8] + "' to an int.";
						throw new IOException();
					}
					try{
						testInt = Integer.parseInt(data[9]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[9] + "' to an int.";
						throw new IOException();
					}
					try{
						testInt = Integer.parseInt(data[10]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[10] + "' to an int.";
						throw new IOException();
					}
					try{
						testFloat = Float.parseFloat(data[11]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[11] + "' to a float.";
						throw new IOException();
					}
					try{
						testFloat = Float.parseFloat(data[12]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[12] + "' to a float.";
						throw new IOException();
					}
					try{
						testFloat = Float.parseFloat(data[13]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[13] + "' to a float.";
						throw new IOException();
					}
					try{
						testInt = Integer.parseInt(data[14]); 
					}
					catch (NumberFormatException nfe) {
						error = "Unable to convert '" + data[14] + "' to an int.";
						throw new IOException();
					}
					conditions = data[15];
					if(data.length > 16) {
						for(int i = 15; i < data.length-1; i++) {
							conditions = conditions + ", " + data[i];
						}
						conditions = conditions + " and " + data[data.length-1];
					}
					cities.add(new weatherObj(data[0], data[1], data[2] , Float.parseFloat(data[3]), Float.parseFloat(data[4]), data[5], data[6] , Integer.parseInt(data[7]), Integer.parseInt(data[8]), 
						Integer.parseInt(data[9]), Integer.parseInt(data[10]), Float.parseFloat(data[11]), 
						Float.parseFloat(data[12]), Float.parseFloat(data[13]), Integer.parseInt(data[14]), conditions));
					line = br.readLine();
				}
				br.close();
				fr.close();
				readFile = true;
				System.out.println();
			} catch (FileNotFoundException fnfe) {
				System.out.println("The file " + filename + " could not be found.");
				System.out.println();
			} catch (IOException ioe) {
				System.out.println("This file " + filename + " is not formatted properly.");
				System.out.println(error);
				System.out.println();
			}
		}
		
		Boolean cityInfo = false;
		int cityInd = -1;
		int infoNum = -1;
		String searchCity = "";
		Boolean allFlag = false;
		
		while(!searchCity.equalsIgnoreCase("exit")) {
		
			while(cityInfo == false) {
				System.out.print("For what city would you like weather information? ");
				searchCity = scan.nextLine();
				System.out.println();
				cityInd = -1;
				
				if(searchCity.equalsIgnoreCase("exit")) {
					break;
				}
				
				if(searchCity.equalsIgnoreCase("all")) {
					cityInfo = true;
					allFlag = true;
					
					System.out.println("I do have information about the weather in all cities.");
					System.out.println();
					
					System.out.println("\t1) Temperature");
					System.out.println("\t2) High and low temperature today");
					System.out.println("\t3) Humidity");
					System.out.println("\t4) Pressure");
					System.out.println("\t5) Visibility");
					System.out.println("\t6) Wind speed and direction");
					System.out.println("\t7) Descriptions of weather conditions");
					System.out.println("\t8) Everything");
					System.out.println("\t9) Enter a different city");
					System.out.println();
					break;
				}
				
				for(int i = 0; i < cities.size(); i++) {
					if(cities.get(i).getName().equalsIgnoreCase(searchCity)) {
						cityInd = i;
						cityInfo = true;
						
						System.out.println("I do have information about the weather in " + cities.get(cityInd).getName() + ".");
						System.out.println();
						
						System.out.println("\t1) Temperature");
						System.out.println("\t2) High and low temperature today");
						System.out.println("\t3) Humidity");
						System.out.println("\t4) Pressure");
						System.out.println("\t5) Visibility");
						System.out.println("\t6) Wind speed and direction");
						System.out.println("\t7) Descriptions of weather conditions");
						System.out.println("\t8) Everything");
						System.out.println("\t9) Enter a different city");
						System.out.println();
						break;
					}
				}
				
				if(cityInd == -1 && allFlag == false) {
					System.out.println("Unable to find city " + searchCity + ".");
					System.out.println();
				}
			}
			
			if(searchCity.equalsIgnoreCase("exit")) {
				break;
			}
			
			System.out.print("What information would you like to know? ");
			try{
				infoNum = Integer.parseInt(scan.nextLine());
//				System.out.println();
			}
			catch (NumberFormatException nfe) {
				System.out.println();
				infoNum = -1;
				System.out.print("That is not a valid option.");
				System.out.println();
			}
			System.out.println();
			
			if(infoNum == 1) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The temperature in " + cities.get(i).getName() +
								" is " + cities.get(i).getTemp() + " degrees Farenheit.");
					}
					System.out.println();
				}
				else {
					System.out.println("The temperature in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getTemp() + " degrees Farenheit.");
					System.out.println();
				}
			}
			else if(infoNum == 2) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The high temperature in " + cities.get(i).getName() + 
								" is " + cities.get(i).getHigh() + " degrees Farenheit.");
						System.out.println("The low temperature in " + cities.get(i).getName() + 
								" is " + cities.get(i).getLow() + " degrees Farenheit.");
					}
					System.out.println();
				}
				else {
					System.out.println("The high temperature in " + cities.get(cityInd).getName() + 
							" is " + cities.get(cityInd).getHigh() + " degrees Farenheit.");
					System.out.println("The low temperature in " + cities.get(cityInd).getName() + 
							" is " + cities.get(cityInd).getLow() + " degrees Farenheit.");
					System.out.println();
				}
			}
			else if(infoNum == 3) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The humidity in " + cities.get(i).getName() +
								" is " + cities.get(i).getHumidity() + "%.");
					}
					System.out.println();
				}
				else {
					System.out.println("The humidity in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getHumidity() + "%.");
					System.out.println();
				}
			}
			else if(infoNum == 4) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The pressure in " + cities.get(i).getName() +
								" is " + cities.get(i).getPressure() + " Inch Hg.");
					}
					System.out.println();
				}
				else {
					System.out.println("The pressure in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getPressure() + " Inch Hg.");
					System.out.println();
				}
			}
			else if(infoNum == 5) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The visibility in " + cities.get(i).getName() +
								" is " + cities.get(i).getVisibility() + " miles.");
					}
					System.out.println();
				}
				else {
					System.out.println("The visibility in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getVisibility() + " miles.");
					System.out.println();
				}
			}
			else if(infoNum == 6) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The wind speed in " + cities.get(i).getName() +
								" is " + cities.get(i).getWindspeed() + " miles/hour.");
						System.out.println("The wind direction in " + cities.get(i).getName() +
								" is " + cities.get(i).getWindDir() + " degrees.");
					}
					System.out.println();
				}
				else {
					System.out.println("The wind speed in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getWindspeed() + " miles/hour.");
					System.out.println("The wind direction in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getWindDir() + " degrees.");
					System.out.println();
				}
			}
			else if(infoNum == 7) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println(cities.get(i).getName() + " weather can be "
								+ "described as " + cities.get(i).getConditions() + ".");
					}
					System.out.println();
				}
				else {
					System.out.println(cities.get(cityInd).getName() + " weather can be "
							+ "described as " + cities.get(cityInd).getConditions() + ".");
					System.out.println();
				}
			}
			else if(infoNum == 8) {
				if(allFlag == true) {
					for(int i = 0; i < cities.size(); i++) {
						System.out.println("The temperature in " + cities.get(i).getName() +
								" is " + cities.get(i).getTemp() + " degrees Farenheit.");
						System.out.println("The high temperature in " + cities.get(i).getName() + 
								" is " + cities.get(i).getHigh() + " degrees Farenheit.");
						System.out.println("The low temperature in " + cities.get(i).getName() + 
								" is " + cities.get(i).getLow() + " degrees Farenheit.");
						System.out.println("The humidity in " + cities.get(i).getName() +
								" is " + cities.get(i).getHumidity() + "%.");
						System.out.println("The pressure in " + cities.get(i).getName() +
								" is " + cities.get(i).getPressure() + " Inch Hg.");
						System.out.println("The visibility in " + cities.get(i).getName() +
								" is " + cities.get(i).getVisibility() + " miles.");
						System.out.println("The wind speed in " + cities.get(i).getName() +
								" is " + cities.get(i).getWindspeed() + " miles/hour.");
						System.out.println("The wind direction in " + cities.get(i).getName() +
								" is " + cities.get(i).getWindDir() + " degrees.");
						System.out.println(cities.get(i).getName() + " weather can be "
								+ "described as " + cities.get(i).getConditions() + ".");	
						System.out.println();
					}
				}
				else {
					System.out.println("The temperature in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getTemp() + " degrees Farenheit.");
					System.out.println("The high temperature in " + cities.get(cityInd).getName() + 
							" is " + cities.get(cityInd).getHigh() + " degrees Farenheit.");
					System.out.println("The low temperature in " + cities.get(cityInd).getName() + 
							" is " + cities.get(cityInd).getLow() + " degrees Farenheit.");
					System.out.println("The humidity in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getHumidity() + "%.");
					System.out.println("The pressure in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getPressure() + " Inch Hg.");
					System.out.println("The visibility in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getVisibility() + " miles.");
					System.out.println("The wind speed in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getWindspeed() + " miles/hour.");
					System.out.println("The wind direction in " + cities.get(cityInd).getName() +
							" is " + cities.get(cityInd).getWindDir() + " degrees.");
					System.out.println(cities.get(cityInd).getName() + " weather can be "
							+ "described as " + cities.get(cityInd).getConditions() + ".");	
					System.out.println();
				}
			}
			else if(infoNum == 9) {
				cityInfo = false;
				allFlag = false;
			}
		}
		
		System.out.println("Thank you for using my weather program.");
		
		scan.close();
		
	}
}