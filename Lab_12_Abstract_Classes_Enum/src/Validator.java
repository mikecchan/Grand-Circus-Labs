import java.util.Scanner;

public class Validator
{
	public static Scanner sc = new Scanner(System.in);
	
    public static String getString(String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }

    public static int getInt(String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(prompt);
            if (i < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (i > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(String prompt,
    double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(prompt);
            if (d < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (d > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return d;
    }
    
    public static boolean doAgain(String prompt) {
		String cont = null;
		boolean decision = false;
		cont = Validator.getString(prompt);
		
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