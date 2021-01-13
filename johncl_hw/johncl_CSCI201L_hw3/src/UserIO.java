import java.util.Scanner;

public class UserIO {
	FileIO fio;
	Scanner scan;
	UserIO(FileIO fio, Scanner scan) throws ExitException {
		this.fio = fio;
		this.scan = scan;
		boolean found = false;
		System.out.println("");
		while(!found) {
			try {
				System.out.print("For what city would you like weather information? ");
				String name = scan.nextLine();
				if (name.trim().equalsIgnoreCase("exit")) {
					System.out.println("\nThank you for using my weather program.");
					throw new ExitException();
				}
				verifyCity(name.trim());
			} catch(DifferentCityException ee) {
				continue;
			}
		}
	}
	public void printOptions() {
		System.out.println("");
		System.out.println("\t1) Temperature\n" + 
				"\t2) High and low temperature today\n" + 
				"\t3) Humidity\n" + 
				"\t4) Pressure\n" + 
				"\t5) Visibility\n" + 
				"\t6) Wind speed and direction\n" + 
				"\t7) Descriptions of weather conditions\n" + 
				"\t8) Everything\n" + 
				"\t9) Enter a different city");
	}

	public void verifyOptions(City i, String consume, boolean all, boolean last) throws DifferentCityException {
		int option = Integer.parseInt(consume);
		if (!all) System.out.println("");
		if (option >= 1 && option <= 7) {
			System.out.println(i.printStrings[option-1]);
			if (all && (option == 2 || option == 6) && !last) System.out.println("");
		}
		else if (option == 8) {
			for (int j = 0; j < 7; j++) {
				System.out.println(i.printStrings[j]);
			}
			if (all && !last) System.out.println("");
		}
		else if (option == 9) {
			throw new DifferentCityException();
		}
		else {
			throw new FormatException();
		}
	}
	public void verifyCity(String name) throws DifferentCityException {
		if (name.equalsIgnoreCase("all")) {
			System.out.println("\nI do have information about the weather in all cities.");
			printOptions();
			boolean  exit = false;
			System.out.println("");
			while (!exit) {
				try {
					System.out.print("What information would you like to know? ");
					String consume = scan.nextLine();
					System.out.println("");
					for (int j = 0; j < fio.getCities().size(); j++) {
						if (j == fio.getCities().size()-1) verifyOptions(fio.getCities().get(j), consume, true, true);
						else verifyOptions(fio.getCities().get(j), consume.trim(), true, false);
					}
					System.out.println("");
				} catch (NumberFormatException nfe) {
					System.out.println("That is not a valid option.\n");
				} 
			}
		}
		for (City i : fio.getCities()) {
			if (name.equalsIgnoreCase(i.getName())) {
				System.out.println("\nI do have information about the weather in " + i.getName() + ".");
				printOptions();
				boolean  exit = false;
				while (!exit) {
					try {
						System.out.print("\nWhat information would you like to know? ");
						String consume = scan.nextLine();
						verifyOptions(i, consume.trim(), false, false);
					} catch (FormatException fe) {
						System.out.println("That is not a valid option.");
					} catch (NumberFormatException nfe) {
						System.out.println("\nThat is not a valid option.");
					} 
				}
			}
		}
		System.out.println("\nUnable to find city " + name + ".\n");
	}
}