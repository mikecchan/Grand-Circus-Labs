import java.util.Scanner;
import java.util.InputMismatchException;

/* 
 * @author: Michael Chan
 * Lab 7 - 10/29/17
 * In this lab, I am primarily demonstrating my knowledge of using Arrays
 * and the try/catch method.
 * 
 * My task in this lab is to write a program that will recognize invalid inputs 
 * when the user requests information about students in a class
 */

public class Invalid_Inputs {
	
	static String [][] pArray = new String[6][3];
	static Scanner scnr = new Scanner(System.in);
	static int name;
	static String category;
	static boolean keepGoing = true;

	public static void main(String[] args) {
		
		fillArray();

		while(keepGoing) {
		
			studentInput();
		
			categoryInput();
			
			doAgain();
		}
	}
	
	public static void fillArray() {
		
		/* 
		 * In this method, I am filling the the 2D array to store information
		 * for each student: their name, hometown, and favorite food.
		 */
		
		pArray[0][0] = "Michael Chan";
		pArray[0][1] = "Rochester Hills, MI";
		pArray[0][2] = "Sushi";
		
		pArray[1][0] = "Yasmin Rodriguez";
		pArray[1][1] = "Ann Arbor, MI";
		pArray[1][2] = "Indian";
		
		pArray[2][0] = "Pratima Kaza";
		pArray[2][1] = "Edingburg, TX";
		pArray[2][2] = "Indian";
		
		pArray[3][0] = "Samuel Bernardy";
		pArray[3][1] = "Livonia, MI";
		pArray[3][2] = "Human Flesh";
		
		pArray[4][0] = "Marcus Perez";
		pArray[4][1] = "Adrian, MI";
		pArray[4][2] = "Fruit";
		
		pArray[5][0] = "Tim Johnson";
		pArray[5][1] = "Los Angeles, CA";
		pArray[5][2] = "Ethnic";
	}
	
	public static void studentInput() {
		
		/*
		 * In this method, I am prompting users to enter a value from 0 to maximum length of the array to
		 * return back the user's name.
		 */
		
		System.out.println("Welcome to our Java class. Which student would you like to learn more about? +"
				+ " (enter a number between 0 and " + (pArray.length - 1) + ")");
		
		/*
		 * Below, I added try/catch block statements to ensure the user inputs the correct information
		 * in the scanner.
		 */
		
		try {
			name = scnr.nextInt();
			System.out.println("You entered: " + name + ".  Now checking if this is valid...");
			System.out.println("Student you want to look up is " + pArray[name][0]);
		}
		catch(IndexOutOfBoundsException | IllegalArgumentException | InputMismatchException e) {
			System.out.println("Error.  Please only enter an integer between 0 and " + (pArray.length-1));
			scnr.nextLine();
			studentInput();
		}
	}
	
	public static void categoryInput() {
		
		/*
		 * In this method, after user entered a valid number to find a student in class, 
		 * I am now prompting users to enter a valid keyword to return that student's certain info.
		 */
		
		System.out.println("Please enter the word: 'hometown' or 'favoritefood'");
		category = scnr.next();
		
		if (category.equalsIgnoreCase("hometown")) {
			System.out.println(pArray[name][0] + "'s hometown is " + pArray[name][1]);
		}
		else if (category.equalsIgnoreCase("favoritefood")) {
			System.out.println(pArray[name][0] + "'s favorite food is " + pArray[name][2]);
		}
		else {
			System.out.println("Error!");
			scnr.nextLine();
			categoryInput();
		}
	}
	
	public static void doAgain() {
		
		/*
		 * Last, this method asks if users want to try this run this application again.
		 */
		
		System.out.println("Would you like to try again?  Please enter 'yes' or 'no'");
		
		String yesOrNo = scnr.next();
		if (yesOrNo.equalsIgnoreCase("yes")) {
			System.out.println("Playing Again...");
		}
		else if (yesOrNo.equalsIgnoreCase("no")) {
			System.out.println("Goodbye!");
			keepGoing = false;
		}
		else {
			System.out.println("Please only enter either 'yes' or 'no' only!");
			doAgain();
		}
	}
}
