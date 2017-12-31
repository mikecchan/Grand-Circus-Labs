import java.util.ArrayList;
import java.util.Scanner;

/*
 * @Author: Michael Chan
 * Lab 9
 * In this application, I am holding details of cars that users
 * will input.
 * 
 * The specification is as followed:
 * 1) Prompt user how many cars they want to enter.
 * 2) For each car, take input for details.
 * 3) Print out a table of the cars at the end
 */

public class CarApp {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean keepGoing = true;
		
		while(keepGoing) {
			int num = howMany();
			ArrayList<Car> carsList = createCars(num);
			printCars(carsList);
			keepGoing = doAgain();
		}
	}
	
	//This method takes input from user how many cars to store.
	public static int howMany() {
		int num = Validator.getInt(sc, "How many cars do you want?");
		return num;
	}
	
	//This method creates an array of the number of cars the user had specified
	//and each car will have the Make, Model, Year, and Price specified.
	public static ArrayList<Car> createCars(int num) {
		ArrayList<Car> carsList = new ArrayList<Car>();
		String make;
		String model;
		int year;
		double price;
		for (int i = 0 ; i < num ; i++) {
			System.out.println("Details for vehicle number: " + (i + 1));
			make = Validator.getString(sc, "Please enter a make for this vehicle ");
			model = Validator.getString(sc, "Please enter a model for this vehicle ");
			year = Validator.getInt(sc, "Please enter a year for this vehicle ");
			price = Validator.getInt(sc, "Please enter a price for this vehicle ");
			carsList.add(new Car(make, model, year, price));
		}
		return carsList;
	}
	
	//This method will print out a table of all the cars in detail.
	public static void printCars(ArrayList<Car> carsList) {
		System.out.printf("%-5s | %-5s | %-5s | %-5s\n", "Make", "Model" , "Year", "Price");
		System.out.printf("-------------------------\n");
		for (int i = 0 ; i < carsList.size() ; i++) {
			System.out.print(carsList.get(i));
		}
	}
	
	//This method prompts user if he/she would like to rerun this application again.
	public static boolean doAgain() {
		String cont = null;
		boolean decision = false;
		cont = Validator.getString(sc, "Continue? Please only enter yes or no: ");
		
		if (cont.equalsIgnoreCase("y") || cont.equalsIgnoreCase("yes")){
			System.out.println("User entered 'yes'");
			decision = true;
		}
		else if (cont.equalsIgnoreCase("n") || cont.equalsIgnoreCase("no"))  {
			System.out.println("User entered 'no'");
			decision = false;
		}
		else {
			System.out.println("Please enter either 'y', 'yes', 'n', or 'no'");
			doAgain();
		}
		return decision;
	}
}
