package uoa.assignment.game;


public class RunGame {

	private static boolean gameOver = false;


	public static void main(String[] args) {
    
    int height = Integer.parseInt(args[0]);
    int width = Integer.parseInt(args[1]);
    GameLogic gamelogic = new GameLogic();


    Game game = new Game(height, width);
    Map map = game.getMap();

    int round = 1;
    
    while (!gameOver) {
      System.out.println("Round " + round);
      round++;
      String input = gamelogic.input.next();
      gameOver = game.nextRound(input);
    }
	}
}
