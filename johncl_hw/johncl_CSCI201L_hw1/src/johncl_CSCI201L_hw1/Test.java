package johncl_CSCI201L_hw1;

import java.io.*;
import java.util.*; 

public class Test {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
//			file checkpoint
			System.out.println("What is the name of the weather file? ");
			Scanner in = new Scanner(System.in);//Cin
			String input = in.nextLine(); //Cin
			fr = new FileReader(input);
			br = new BufferedReader(fr);
			String line = br.readLine(); //Line by line
			ArrayList<city> city_list = new ArrayList<city>();
			while (line != null) {
				if(line.length() < 10) {
					System.out.println("not enough parameters");
					break;
				}
				String[] result = line.split("\\|");
				String cond = "";
				for(int j=9 ; j < result.length ; j++) {
					cond += result[j];
					if(j< result.length-2) {
						cond += ", ";
					}
					else if(j == result.length-2) {
						cond += " and ";
					}
				}
				city c = new city(result[0], Integer.parseInt(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]), Float.parseFloat(result[5]), Float.parseFloat(result[6]), Float.parseFloat(result[7]), Float.parseFloat(result[8]), cond);
				city_list.add(c);
				line = br.readLine();
			}
//			Check if variables are inserted correctly to class
//			for(int z = 0; z < city_list.size(); z++) {
//				city_list.get(z).printCity();
//			}
			System.out.println("For what city would you like weather information? ");
			Scanner reader = new Scanner(System.in);
			String city_name;
			int city_index = -2;
//			Prompt city name from User
			while((city_name = reader.nextLine() ) != null ) {
//				find city by name
				for(int k = 0; k<city_list.size(); k++) {
					if( city_name.equalsIgnoreCase(city_list.get(k).name)) {
						city_index = k;
						break;
					}
				}
//				all cities condition
				if(city_name.equalsIgnoreCase("all") ) {
					city_index = -1;
//					System.out.println("You inputed all");
					break;
				}
//				City name not found
				else if(city_index == -2) {
					System.out.println("Unable to find city " + city_name);
				}
//				City name found
				else if(city_index >= 0) {
//					System.out.println("FOUND");
					break;
				}
				System.out.println("For what city would you like weather information? ");
			}
//			Prompt information about the city from user
			if(city_index == -1) {
				System.out.println("	I do have information about the weather in all cities");
			}
			else {
				System.out.println("	I do have information about the weather in " + city_list.get(city_index).name);
			}
			System.out.println("	1) Temperature");
			System.out.println("	2) High and low temperature today");
			System.out.println("	3) Humidity");
			System.out.println("	4) Pressure");
			System.out.println("	5) Visibility");
			System.out.println("	6) Wind speed and direction");
			System.out.println("	7) Descriptions of weather conditions");
			System.out.println("	8) Everything");
			System.out.println("	9) Enter a different city");
			System.out.println("What information would you like to know?");
			Scanner hit = new Scanner(System.in);
			int hit_index;
			String hit_word;
			while(true) {
				try {
					hit_index = hit.nextInt();
					if(hit_index == 1) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The temperature in " + city_list.get(k).name + " is " + city_list.get(k).currTemp + " degrees Fahrenheit.");
							}
						}
						else {
							System.out.println("The temperature in " + city_name + " is " + city_list.get(city_index).currTemp + " degrees Fahrenheit.");
						}	
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 2) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The high temperature in " + city_list.get(k).name + " is " + city_list.get(k).dayHigh + " degrees Fahrenheit.");
								System.out.println("The low temperature in " + city_list.get(k).name + " is " + city_list.get(k).dayLow + " degrees Fahrenheit.");
							}
						}
						else {
							System.out.println("The high temperature in " + city_name + " is " + city_list.get(city_index).dayHigh + " degrees Fahrenheit.");
							System.out.println("The low temperature in " + city_name + " is " + city_list.get(city_index).dayLow + " degrees Fahrenheit.");
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 3) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The humidity in " + city_list.get(k).name + " is " + city_list.get(k).humidity + "%");
							}
						}
						else {
							System.out.println("The humidity in " + city_name + " is " + city_list.get(city_index).humidity + "%");
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 4) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The pressure in " + city_list.get(k).name + " is " + city_list.get(k).pressure + " Inch Hg.");
							}
						}
						else {
							System.out.println("The pressure in " + city_name + " is " + city_list.get(city_index).pressure + " Inch Hg.");
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 5) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The visibility in " + city_list.get(k).name + " is " + city_list.get(k).visibility + " miles.");
							}
						}
						else {
							System.out.println("The visibility in " + city_name + " is " + city_list.get(city_index).visibility + " miles.");
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 6) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The wind speed in " + city_list.get(k).name + " is " + city_list.get(k).windspeed + " miles/hour.");
								System.out.println("The wind direction in " + city_list.get(k).name + " is " + city_list.get(k).windDir + " degrees.");							}
						}
						else {
							System.out.println("The wind speed in " + city_name + " is " + city_list.get(city_index).windspeed + " miles/hour.");
							System.out.println("The wind direction in " + city_name + " is " + city_list.get(city_index).windDir + " degrees.");
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 7) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println(city_list.get(k).name + "weather can be described as " + city_list.get(k).condition);
							}
						}
						else {
							System.out.println(city_name + "weather can be described as " + city_list.get(city_index).condition);
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 8) {
						if(city_index == -1) {
							for(int k = 0; k<city_list.size(); k++) {
								System.out.println("The temperature in " + city_list.get(k).name + "is " + city_list.get(k).currTemp + " degrees Fahrenheit.");
								System.out.println("The high temperature in " + city_list.get(k).name + "is " + city_list.get(k).dayHigh + " degrees Fahrenheit.");
								System.out.println("The low temperature in " + city_list.get(k).name + "is " + city_list.get(k).dayLow + " degrees Fahrenheit.");
								System.out.println("The humidity in " + city_list.get(k).name + "is " + city_list.get(k).humidity + "%.");
								System.out.println("The pressure in " + city_list.get(k).name + "is " + city_list.get(k).pressure + " Inch Hg.");
								System.out.println("The visibility in " + city_list.get(k).name + "is " + city_list.get(k).visibility + " miles.");
								System.out.println("The wind speed in " + city_list.get(k).name + "is " + city_list.get(k).windspeed + " miles/hour.");
								System.out.println("The wind direction in " + city_list.get(k).name + "is " + city_list.get(k).windDir + " degrees.");
								System.out.println(city_list.get(k).name + "weather can be described as " + city_list.get(k).condition);							}
						}
						else {
							System.out.println("The temperature in " + city_name + "is " + city_list.get(city_index).currTemp + " degrees Fahrenheit.");
							System.out.println("The high temperature in " + city_name + "is " + city_list.get(city_index).dayHigh + " degrees Fahrenheit.");
							System.out.println("The low temperature in " + city_name + "is " + city_list.get(city_index).dayLow + " degrees Fahrenheit.");
							System.out.println("The humidity in " + city_name + "is " + city_list.get(city_index).humidity + "%.");
							System.out.println("The pressure in " + city_name + "is " + city_list.get(city_index).pressure + " Inch Hg.");
							System.out.println("The visibility in " + city_name + "is " + city_list.get(city_index).visibility + " miles.");
							System.out.println("The wind speed in " + city_name + "is " + city_list.get(city_index).windspeed + " miles/hour.");
							System.out.println("The wind direction in " + city_name + "is " + city_list.get(city_index).windDir + " degrees.");
							System.out.println(city_name + "weather can be described as " + city_list.get(city_index).condition);						
						}
						System.out.println();
						System.out.println("What information would you like to know?");
					}
					else if(hit_index == 9) {
						System.out.println("For what city would you like weather information? ");
						Scanner scan = new Scanner(System.in);
						city_index = -2;
//						Prompt city name from User
						while((city_name = scan.nextLine() ) != null ) {
//							find city by name
							for(int k = 0; k<city_list.size(); k++) {
								if( city_name.equalsIgnoreCase(city_list.get(k).name)) {
									city_index = k;
									break;
								}
							}
//							all cities condition
							if(city_name.equalsIgnoreCase("all") ) {
								city_index = -1;
							}
//							City name not found
							else if(city_index == -2){
								System.out.println("Unable to find city " + city_name);
							}
//							City name found
							else if(city_index >= 0) {
//								System.out.println("FOUND");
								break;
							}
							System.out.println("For what city would you like weather information? ");
						}
						System.out.println("	1) Temperature");
						System.out.println("	2) High and low temperature today");
						System.out.println("	3) Humidity");
						System.out.println("	4) Pressure");
						System.out.println("	5) Visibility");
						System.out.println("	6) Wind speed and direction");
						System.out.println("	7) Descriptions of weather conditions");
						System.out.println("	8) Everything");
						System.out.println("	9) Enter a different city");
						System.out.println("What information would you like to know?");
					}
				} finally {
					hit_word = hit.nextLine();
					if(hit_word.equalsIgnoreCase("exit") ) {
						System.out.println("Thank you for using my weather program.");
						break;
					}
				}
			}
			reader.close();
			in.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage() );
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage() );
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage() );
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch(IOException ioe) {
					System.out.println(ioe.getMessage() );
				}
 			}
		}
	}
}
