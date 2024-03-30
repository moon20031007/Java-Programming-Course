package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

  Scanner input = new Scanner(System.in);

  public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
    if(input.equals("up")) {
      if(character.row - 1 >= 0){
        if(character instanceof Monster) {
          if(character.getHealth() > 0){
            if(gameMap.layout[character.row - 1][character.column] == "%") {
              System.out.println("Monster already there so can't move");
            }else if(gameMap.layout[character.row - 1][character.column] == "*"){
              Monster monster = (Monster) character;
              monster.hurtCharacter(gameMap.characters[0]);
            }else if(gameMap.layout[character.row - 1][character.column] == "x"){
              System.out.println("Character already dead");
            }else {
              moveUp(character, gameMap);
            }
          }
        }else {
          if(gameMap.layout[character.row - 1][character.column] == "%") {
            for(GameCharacter hurtcharacter : gameMap.characters) {
              if(hurtcharacter.row == character.row - 1 && hurtcharacter.column == character.column) {
                Player player = (Player) character;
                player.hurtCharacter(hurtcharacter);
                if (hurtcharacter.getHealth() <= 0){
                  gameMap.layout[hurtcharacter.row][hurtcharacter.column] = "x";
                }
              }
            }
          }else if(gameMap.layout[character.row - 1][character.column] == "x"){
            System.out.println("Character already dead");
          }else {
            moveUp(character, gameMap);
          }
        }
      }else {
        System.out.println("You can't go up. You lose a move");
      }
    }else if(input.equals("down")) {
      if(character.row + 1 < gameMap.layout.length) {
        if(character instanceof Monster) {
          if(character.getHealth() > 0) {
            if(gameMap.layout[character.row + 1][character.columnassignment] == "%") {
              System.out.println("Monster already there so can't move");
            }else if(gameMap.layout[character.row + 1][character.column] == "*") {
              Monster monster = (Monster) character;
              monster.hurtCharacter(gameMap.characters[0]);
            }else if(gameMap.layout[character.row + 1][character.column] == "x") {
              System.out.println("Character already dead");
            }else {
              moveDown(character, gameMap);
            }
          }
        }else {
          if(gameMap.layout[character.row + 1][character.column] == "%") {
            for(GameCharacter hurtcharacter : gameMap.characters) {
              if(hurtcharacter.row == character.row + 1 && hurtcharacter.column == character.column) {
                Player player = (Player) character;
                player.hurtCharacter(hurtcharacter);
                if (hurtcharacter.getHealth() <= 0){
                  gameMap.layout[hurtcharacter.row][hurtcharacter.column] = "x";
                }
              }
            }
          }else if(gameMap.layout[character.row + 1][character.column] == "x") {
            System.out.println("Character already dead");
          }else {
            moveDown(character, gameMap);
          }
        }
      }else {
        System.out.println("You can't go down. You lose a move");
      }
    }else if(input.equals("right")) {
      if(character.column + 1 < gameMap.layout[0].length) {
        if(character instanceof Monster) {
          if(character.getHealth() > 0) {
            if(gameMap.layout[character.row][character.column + 1] == "%") {
              System.out.println("Monster already there so can't move");
            }else if(gameMap.layout[character.row][character.column + 1] == "*"){
              Monster monster = (Monster) character;
              monster.hurtCharacter(gameMap.characters[0]);
            }else if(gameMap.layout[character.row + 1][character.column] == "x") {
              System.out.println("Character already dead");
            }else {
              moveRight(character, gameMap);
            }
          }
        }else {
          if(gameMap.layout[character.row][character.column + 1] == "%") {
            for(GameCharacter hurtcharacter : gameMap.characters) {
              if(hurtcharacter.row == character.row && hurtcharacter.column == character.column + 1) {
                Player player = (Player) character;
                player.hurtCharacter(hurtcharacter);
                if (hurtcharacter.getHealth() <= 0){
                  gameMap.layout[hurtcharacter.row][hurtcharacter.column] = "x";
                }
              }
            }
          }else if(gameMap.layout[character.row][character.column + 1] == "x") {
            System.out.println("Character already dead");
          }else{
            moveRight(character, gameMap);
          }
        }
      }else {
      System.out.println("You can't go right. You lose a move");
      }
    }else if(input.equals("left")) {
      if(character.column - 1 >= 0) {
        if(character instanceof Monster) {
          if(character.getHealth() > 0) {
            if(gameMap.layout[character.row][character.column - 1] == "%") {
              System.out.println("Monster already there so can't move");
            }else if(gameMap.layout[character.row][character.column - 1] == "*"){
              Monster monster = (Monster) character;
              monster.hurtCharacter(gameMap.characters[0]);
            }else if(gameMap.layout[character.row][character.column - 1] == "x") {
              System.out.println("Character already dead");
            }else {
              moveLeft(character, gameMap);
            }
          }
        }else {
          if(gameMap.layout[character.row][character.column - 1] == "%") {
            for(GameCharacter hurtcharacter : gameMap.characters) {
              if(hurtcharacter.row == character.row && hurtcharacter.column == character.column - 1) {
                Player player = (Player) character;
                player.hurtCharacter(hurtcharacter);
                if (hurtcharacter.getHealth() <=- 0){
                  gameMap.layout[hurtcharacter.row][hurtcharacter.column] = "x";
                }
              }
            }
          }else if(gameMap.layout[character.row][character.column - 1] == "x") {
            System.out.println("Character already dead");
          }else{
            moveLeft(character, gameMap);
          }
        }
      }else {
      System.out.println("You can't go left. You lose a move");
      } 
    }else {
      System.out.println("Use only keywords up, down, left, right");
    }
  } 

  private static void moveRight(GameCharacter character, Map gameMap) {
    gameMap.layout[character.row][character.column] = ".";
    character.column = character.column + 1;
    if (character instanceof Player) {
      gameMap.layout[character.row][character.column] = "*"; 
    } else if (character instanceof Monster) {
      gameMap.layout[character.row][character.column] = "%"; 
    }
  } 

  private static void moveLeft(GameCharacter character, Map gameMap) {
    gameMap.layout[character.row][character.column] = ".";
    character.column = character.column - 1;
    if (character instanceof Player) {
      gameMap.layout[character.row][character.column] = "*"; 
    } else if (character instanceof Monster) {
      gameMap.layout[character.row][character.column] = "%"; 
    }
  }

  private static void moveUp(GameCharacter character, Map gameMap) {
    gameMap.layout[character.row][character.column] = ".";
    character.row = character.row - 1;
    if (character instanceof Player) {
      gameMap.layout[character.row][character.column] = "*"; 
    } else if (character instanceof Monster) {
      gameMap.layout[character.row][character.column] = "%"; 
    }
  } 

  private static void moveDown(GameCharacter character, Map gameMap) {
    gameMap.layout[character.row][character.column] = ".";
    character.row = character.row + 1;
    if (character instanceof Player) {
      gameMap.layout[character.row][character.column] = "*"; 
    } else if (character instanceof Monster) {
      gameMap.layout[character.row][character.column] = "%"; 
    }
  } 
}
