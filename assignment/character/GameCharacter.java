package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health = 100;
	
	public int row = 0;
	public int column = 0;
	
	
	public GameCharacter (String name) {
		this.name = name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
	return name; 
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
  