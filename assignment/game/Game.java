package uoa.assignment.game;

import uoa.assignment.character.Monster;

public class Game {

  private Map map;
  private Monster monster1;
  private Monster monster2;
  private Monster monster3;
    
  Game (int height, int width) {
    map = new Map(height, width);
    monster1 = (Monster) map.characters[1];
    monster2 = (Monster) map.characters[2];
    monster3 = (Monster) map.characters[3];
    map.printLayout();
  }
    			
  public Map getMap() {
    return map;
  }

  public boolean nextRound (String input) {
    if(monster1.getHealth() <= 0 && monster2.getHealth() <= 0 && monster3.getHealth() <= 0) {
      System.out.println("YOU HAVE WON!");
      return true;
    }else if(map.characters[0].getHealth() <= 0){
      System.out.println("YOU HAVE DIED!");
      return true;
    }else{
      //Move the player
      System.out.println("Player is moving " + input);
      GameLogic.moveCharacter(input, map, map.characters[0]);
      //Move monster1
      String move1 = monster1.decideMove();
      System.out.println("Monster1 is moving " + move1);
      GameLogic.moveCharacter(move1, map, monster1);
      //Move monster2
      String move2 = monster2.decideMove();
      System.out.println("Monster2 is moving " + move2);
      GameLogic.moveCharacter(move2, map, monster2);
      //Move monster3
      String move3 = monster3.decideMove();
      System.out.println("Monster3 is moving " + move3);
      GameLogic.moveCharacter(move3, map, monster3);
      //Get the all health
      System.out.println("Health Player: " + map.characters[0].getHealth());
      System.out.println("Health Monster1: " + monster1.getHealth()); 
      System.out.println("Health Monster2: " + monster2.getHealth());
      System.out.println("Health Monster3: " + monster3.getHealth());
      map.printLayout();
      return false;
    }
  }
}