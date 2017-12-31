
public abstract class Player {
	
	String name;
	Roshambo pick;
	int score = 0;
	
	public Player() {	
	}
	
	public abstract Roshambo generateRoshambo();

	public void setPick() {
		this.pick = generateRoshambo();
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Roshambo getPick() {
		return pick;
	}
	
	@Override 
	public String toString() {
		return String.format("%-5s | %-5s",name, score);
	}
}
