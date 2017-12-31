import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author: Michael Chan
 * Lab 10 "Extend your Car Class with a UsedCar subclass".
 * My application will...
 * 1) Display a list of 6 cars ( 3 new and 3 used ).
 * 2) Let the user select one of the cars.
 * 3) Re-display the information for car selected.
 * 4) Ask the user if they want to buy the car.  If they do, remove the car
 * 5) Re-display the list
 * 6) Re-run the program when prompted.
 */

public class Main {

	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean keepGoing = true;
		ArrayList<Car> carList = new ArrayList<>();
		
		while(keepGoing) {
			
			carList = createCarList(carList);
		
			selectCar(carList);
			
			keepGoing = doAgain("Would you like to perform this project again? Please only enter yes or no: ");
		}
	}
	
	//This method fills in the array with inventory of cars.
	public static ArrayList<Car> createCarList(ArrayList<Car> carList){
		carList.clear();
		
		carList.add(new UsedCar(0, 23000.90,"Toyota", "Prius", 2014, 24000, "used"));
		carList.add(new UsedCar(0, 24000.90,"Ford", "Fusion", 2015, 25000, "used"));
		carList.add(new UsedCar(0, 25000.90,"Honda", "Civic", 2016, 26000, "used"));
		carList.add(new Car(0, "Toyota", "Prius", 2014, 24000, "new"));
		carList.add(new Car(0, "Ford", "Fusion", 2015, 25000, "new"));
		carList.add(new Car(0, "Honda", "Civic", 2016, 26000, "new"));
		carList.add(new Car(0, null , null, 0, 0, null));
		
		carList = updateIndex(carList);
		
		return carList;
	}
	
	//This method sets the index of each element in the array.
	public static ArrayList<Car> updateIndex(ArrayList<Car> carList) {
		for (int i = 0 ; i < carList.size() ; i++) {
			carList.get(i).setIndex(i);
		}
		
		return carList;
	}
	
	//This method displays to users the cars in the current inventory
	//and allows them to buy a vehicle buy its index number.
	public static void selectCar(ArrayList<Car> carList) {
		if (carList.size() > 1) {
			System.out.println("Here is a table of available cars...");
		
			displayList(carList);
			
			int carIndex = Validator.getInt(scnr, "Please select/buy a car by its index number", 0, carList.size()-1);
			
			if ((carIndex != (carList.size()-1))) {
				boolean buy = buyCar(carList.get(carIndex));
			
				if (buy){
					updateList(carIndex, carList);
				}
				
				selectCar(carList);
			}
		}
	}
	
	//This method prompts users if they would like to buy the car.
	//This will return a boolean to update or not, the array.
	public static boolean buyCar(Car car) {
		System.out.println("You selected...");
		
		System.out.println(car);
		
		return doAgain("Would you like to purchase this car?");
	}
	
	//When the user decides to buy the vehicle, this method will update the 
	//array by removing the element by the index number.
	public static void updateList(int index, ArrayList<Car> carList) {
	
		carList.remove(index);
		
		carList = updateIndex(carList);
		
		if (carList.size() > 1) {
			System.out.println("Thank you for your purchase, please choose another vehicle...");
		}
	}
	
	//This method displays each car in the inventory.
	//It also displays at the end just the last index number to
	//let users whether they would like to buy another vehicle or exit
	//the application.
	public static void displayList(ArrayList<Car> carList) {
		System.out.printf("%-5s | %-5s | %-5s | %-5s | %-5s |  %-5s | %-5s\n", "Index", "Make", "Model" , "Year", "Price", "Type", "Mileage");
		
		System.out.printf("---------------------------------------\n");
		
		for (int i = 0 ; i < carList.size() ; i++) {
			if (carList.size()-1 == i) {
				System.out.println(i + " Quit");
			}
			else {
				System.out.print(carList.get(i) + "\n");
			}
		}
	}
	
	//This is a general method to let users if they would like to...
	// 1) Purchase another car.
	// 2) Re-run the application.
	public static boolean doAgain(String prompt) {
		String cont = null;
		boolean decision = false;
		cont = Validator.getString(scnr, prompt);
		
		if (cont.equalsIgnoreCase("y") || cont.equalsIgnoreCase("yes")){
			decision = true;
		}
		else if (cont.equalsIgnoreCase("n") || cont.equalsIgnoreCase("no"))  {
			decision = false;
		}
		else {
			System.out.println("Please enter either 'y', 'yes', 'n', or 'no'");
			doAgain(prompt);
		}
		return decision;
	}

}
