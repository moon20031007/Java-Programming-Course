package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

  private Random random = new Random();

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
    boolean successfulDefense = successfulDefense(); 
        if (!successfulDefense) {
            int playerHealth = character.getHealth();
            character.setHealth(playerHealth - 20);
        }
	}

	
	public boolean successfulDefense() {
    return random.nextBoolean();
	}


	
	public String decideMove () {
		int choice = random.nextInt(4);
    switch (choice) {
      case 0:
        return "up";
      case 1:
        return "down";
      case 2:
        return "left";
      case 3:
        return "right";
      default:
         return "up";
    }
	}
}
