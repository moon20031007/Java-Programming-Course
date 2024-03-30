package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

  private Random random = new Random();

	public Player(String name) {
		super(name);
	}

	
	public void hurtCharacter(GameCharacter character) {
		boolean successfulDefense = character.successfulDefense(); 
        if (!successfulDefense) {
            int monsterHealth = character.getHealth();
            character.setHealth(monsterHealth - 50);
        }
	}


	public boolean successfulDefense() {
		return random.nextInt(10) < 3;
	}

}
