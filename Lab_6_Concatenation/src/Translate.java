import java.util.Scanner;

/*
 * @author: Michael Chan
 * Lab 6
 * In this task, I prompt users to enter a sentence and this application will translate that sentence into pig latin.
 * The objective of this lab is to demonstrate my understanding of Stringbuilders, how to obtain and manipulate
 * each character of the Stringbuilder, and how to convert back and forth between Stringbuilders and Strings.
 */

public class Translate {
	
	//Below, I declare the string 'pigLatin' and scanner object globally so they can use in each according method without having to keep passing each time.
	static String pigLatin = "";
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		//I declared a boolean variable to allow users the option to loop through this application while that variable remains set to true.
		boolean keepGoing = true;
		
		//Inside the while loop is where the main content of this application is running through.
		while(keepGoing) {
			enter();
			System.out.println("The pigLatin of your input is: " + pigLatin);
			keepGoing = doAgain();
		}
		
		scnr.close();
	}
	
	//In the 'enter()' method, I am prompting users to enter a sentence he/she wants to translate to pig latin.
	//This application will catch an error if the user does not enter a sentence.
	public static void enter() {
		System.out.println("Please Enter a sentence");
		try {
			String input = scnr.nextLine();
			translate(input);
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("Please enter something.  Try again..");
			enter();
		}
	}
	
	//In this method called from the 'enter()' method, it will go through and translate each word of the inputted sentence into pig latin.
	public static void translate(String input) {
		
		input = input.toLowerCase();
		char check_char;
		String[] strArray = input.split(" ");
		
		//I am taking the user's sentence and splitting it into different separate words being stored in the String array.
		for(int i=0; i < strArray.length ; i++) {
			check_char = strArray[i].charAt(0);
			
			//Below, I am checking if the word starts with a vowel or consonant.  Then will translate that word into pig latin accordingly.
			// In the else statement, meaning if the word is a number of special character, then it will not touched at all.
			if (Character.isLetter(check_char)) {
				if (check_char == 'a' || check_char == 'e' || check_char == 'i' || check_char == 'o' || check_char == 'u' || check_char == 'y') {
					isVowel(strArray[i]);
				}
				else {
					isConsonant(strArray[i]);
				}
			}
			else {
				pigLatin = pigLatin.concat(strArray[i]).concat(" ");
			}
		}
	}
	
	//Words that start with vowels will have 'way' added to the end.
	public static void isVowel(String str) {
		pigLatin = pigLatin.concat(str).concat("way").concat(" ");
	}
	
	//Words that start with a consonant will have each consonant be moved to the end (ones before the vowel letter that is)
	//then 'ay' will be added to the end.
	public static void isConsonant(String str) {
		StringBuilder sb = new StringBuilder(str);
		String moveVowel = "";
		
		for (int j = 0 ; j < sb.length() ; j++) {
			if (sb.charAt(0) != 'a' && sb.charAt(0) != 'e' && sb.charAt(0) != 'i' && sb.charAt(0) != 'o' && sb.charAt(0) != 'u' && sb.charAt(0) != 'y') {
				moveVowel = moveVowel.concat(Character.toString(sb.charAt(0)));
				sb.deleteCharAt(0);
			}
		}
		String newStr = sb.toString();
		pigLatin = pigLatin.concat(newStr).concat(moveVowel).concat("ay").concat(" ");
	}
	
	// This last method tells users after seeing the translated pig latin sentence, if he/she wants to rerun this application again.
	public static boolean doAgain() {
		System.out.println("Would you like to try again?  Please type only 'yes' or 'no'");
		String tryAgain = scnr.nextLine();
		boolean response = true;
		if (tryAgain.equalsIgnoreCase("no")) {
			response = false;
			System.out.println("Bye!");
		}
		else if (tryAgain.equalsIgnoreCase("yes")) {
			response = true;
			System.out.println("Going at it again!");
			pigLatin = "";
		}
		else {
			System.out.println("In valid response.  Please try again.");
			doAgain();
		}
		return response;
	}
}
