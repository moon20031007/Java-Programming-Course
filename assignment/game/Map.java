package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

public String [][] layout;
public GameCharacter characters [] ;
 
  Map (int height, int width) {
    layout = new String[height][width];

    characters = new GameCharacter[4];

    Player player = new Player("Player");
    player.row = height - 1;
    player.column = width - 1;
    characters[0] = player;

    Monster monster1 = new Monster("Monster 1");
    monster1.row = (0);
    monster1.column = width - 1;
    characters[1] = monster1;

    Monster monster2 = new Monster("Monster 2");
    monster2.row = height - 1;
    monster2.column = 0;
    characters[2] = monster2;

    Monster monster3 = new Monster("Monster 3");
    monster3.row = 0;
    monster3.column = 0;
    characters[3] = monster3;

    initialiseArray();
    //Place each character on the layout
    for (GameCharacter character : characters) {  
      int row = character.row;
      int column = character.column;
      if (row >= 0 && row < layout.length && column >= 0 && column < layout[0].length) {
        if (character instanceof Player) {
          layout[row][column] = "*"; 
        } else if (character instanceof Monster) {
          layout[row][column] = "%"; 
        }
      }
    }
  }

  private void initialiseArray() {
    for (int i = 0; i < layout.length; i++) {
      for (int j = 0; j < layout[i].length; j++) {
        layout[i][j] = ".";
      }
    }
  }

  public void printLayout() {
    for (int i = 0; i < layout.length; i++) {
      for (int j = 0; j < layout[i].length; j++) {
        System.out.print(layout[i][j]);
      }
      System.out.println();
    }
  }
}
