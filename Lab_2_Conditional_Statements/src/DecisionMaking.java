import java.util.Scanner;

public class DecisionMaking {
	
	public static Scanner scnr = new Scanner(System.in);
	public static int input;
	
	public static void InputInt() {
		System.out.println("Please enter an integer between 1 and 100");
		input = scnr.nextInt();
		ValidateInput();
	}
	
	public static void ValidateInput() {
		if (input < 1 || input > 100) {
			System.out.print("Integer must be between 1 and 100");
			InputInt();
		}
		else {
			Calculate();
		}
	}
	
	public static void Calculate() {
		if ((input%2)!=0 ) {
			System.out.println(Integer.toString(input)  + " Odd");
		}
		if ((input%2)==0 && (input >= 2 && input <= 25)) {
			System.out.println("Even and less than 25");
		}
		if ((input%2)==0 && (input >= 26 && input <= 60)) {
			System.out.println("Even");
		}
		if ((input%2)==0 && (input > 60)) {
			System.out.println("Even");
		}
		if ((input%2)!=0 && (input > 60)) {
			System.out.println("Odd and over 60");
		}
		System.out.println("Let's play again!");
		
		InputInt();
	}

	public static void main(String[] args) {
		InputInt();
	}

}
