
public class Human extends Player {

	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		String pick = null;
		Roshambo r = null;
		boolean isValid = false;
		
		while(!isValid)  {
			pick = Validator.getString("Please choose 'Rock', 'Paper', or 'Scissors' (r/p/s)");
			
			if (pick.equalsIgnoreCase("r")) {
				r = Roshambo.Rock;
				isValid = true;
			}
			else if (pick.equalsIgnoreCase("p")) {
				r = Roshambo.Paper;
				isValid = true;
			}
			else if (pick.equalsIgnoreCase("s")) {
				r = Roshambo.Scissors;
				isValid = true;
			}
			else {
				System.out.println("Error! Please type only 'r', 'p', or 's'");
			}
		}
		
		return r;
	}

}
