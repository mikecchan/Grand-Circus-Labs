package Classroom_Calc;

import java.util.Scanner;

public class Calculator {
	
	public static Scanner scnr = new Scanner(System.in);

	public static void EnterAndCalculate() {
		double length;
		double width;
		double area;
		double perimeter;

		System.out.println("Enter Length: ");
		length = scnr.nextDouble();

		System.out.println("Enter width: ");
		width = scnr.nextDouble();

		area = length * width;

		perimeter = (length * 2) + (width * 2);

		System.out.println("Area: " + Double.toString(area));

		System.out.println("Perimeter: " + Double.toString(perimeter));

		DoAgain();
	}

	public static void DoAgain() {
		String cont = null;
		
		System.out.println("Continue? (y/n): ");
		cont = scnr.next();
		
		if (cont.equals("y") || cont.equals("yes")){
			System.out.println("User entered 'yes'");
			Calculator.EnterAndCalculate();
		}
		else if (cont.equals("n") || cont.equals("no"))  {
			System.out.println("User entered 'no'");
			scnr.close();
			System.exit(0);
		}
		else {
			System.out.println("Please enter either 'y', 'yes', 'n', or 'no'");
			DoAgain();
		}
	}

	public static void main(String[] args) {

		EnterAndCalculate();

	}
}
