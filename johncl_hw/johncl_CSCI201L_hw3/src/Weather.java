import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Weather {
	public static void main(String[] args) {
		boolean exit = false;
		while (!exit) {
			System.out.print("What is the name of the weather file? ");
			Scanner scan = new Scanner(System.in);
			String fileName = "weather.txt";
			try {
				FileIO fio = new FileIO(fileName);
				@SuppressWarnings("unused")
				UserIO uio = new UserIO(fio, scan);	
			} catch(FileNotFoundException fnfe) {
				System.out.println("\nThe file " + fileName + " could not be found.\n");
			} catch(IOException ioe) {
				System.out.println("I/O Exception");
			} catch(NotEnoughException nee) {
				System.out.println("The file " + fileName + " is not formatted properly.");
				System.out.println(nee.getMessage());
			} catch(FormatException fe) {
				System.out.println("The file " + fileName + " is not formatted properly.");
				System.out.println(fe.getMessage());
			} catch(ExitException ee) {
				exit = true;
				scan.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}