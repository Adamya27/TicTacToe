import Model.Player;
import Service.TicTacToeGame;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDriver {
   public static void main(String args[]) throws FileNotFoundException {
      File file = new File("/Users/b0212222/Downloads/TicTacToe/src/main/input/Input");
      Scanner sc = new Scanner(file);
      int gridSize = sc.nextInt();
      int numberOfPlayers = sc.nextInt();
      List<Player> players = new ArrayList<>();
      for(int i=0; i<numberOfPlayers; i++){
         String playerChar = sc.next();
         String playerName = sc.next();
         Player player = new Player(playerName, playerChar.charAt(0));
         players.add(player);
      }

      System.out.println("GAME BEGINS");

      TicTacToeGame game = new TicTacToeGame(numberOfPlayers, gridSize, players);
      while(!game.isGameEnded()){
         game.displayBoard();
         if(!sc.hasNext()){
            break;
         }
         String row = sc.next();
         if(!sc.hasNext()){
            break;
         }
         String col = sc.next();
         System.out.println(row + " " + col);

         game.playMove(row, col);
      }
//      game.displayBoard();
      System.out.println("GAME ENDED");
   }
}
