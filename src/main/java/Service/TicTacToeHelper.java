package Service;

import Model.Box;
import Model.Player;

import java.util.List;

public class TicTacToeHelper {

    public int getBoxPosition(int row, int col){
        return (row-1)*3 + (col-1);
    }

    public boolean isMoveInvalid(int row, int col, int gridSize,List<Box> boxes){
        if(row > gridSize || col > gridSize){
            return true;
        }
        int boxPosition = getBoxPosition(row,col);
        if(boxes.get(boxPosition).isOccupied()){
            return true;
        }

        return false;
    }


    public Player findWinner(char winnerChar, List<Player> players){

        for (Player player: players){
            if(winnerChar == player.getAllottedCharacter()){
                return player;
            }
        }

        return null;
    }

    public char getWinnerSymbol(int gridSize,List<Box> boxes){

        // row check
        for(int row = 1; row<=gridSize; row++){
            int rowStartingPosition = getBoxPosition(row, 1);
            char rowChar = boxes.get(rowStartingPosition).getSymbol();
            boolean rowCheck = true;
            for(int col = 2; col <= gridSize; col++){
                int boxPosition = getBoxPosition(row,col);
                char currentChar = boxes.get(boxPosition).getSymbol();
                if(rowChar != currentChar){
                    rowCheck = false;
                    break;
                }
            }
            if(rowCheck){
                return rowChar;
            }
        }

        // column check
        for(int col = 1; col <= gridSize; col++){
            int colStartingPosition = getBoxPosition(1, col);
            char colChar = boxes.get(colStartingPosition).getSymbol();
            boolean colCheck = true;
            for(int row = 2; row<=gridSize;row++){
                int boxPosition = getBoxPosition(row,col);
                char currentChar = boxes.get(boxPosition).getSymbol();
                if(colChar != currentChar){
                    colCheck = false;
                    break;
                }
            }
            if(colCheck){
                return colChar;
            }
        }

        // diagnol check
        int boxPositionOfPrimaryDiagnol = getBoxPosition(1, 1);
        char primaryDiagnolChar = boxes.get(boxPositionOfPrimaryDiagnol).getSymbol();
        boolean primaryDiagnolCheck = true;
        int boxPositionOfSecondaryDiagnol = getBoxPosition(1, gridSize);
        char secondaryDiagnolChar = boxes.get(boxPositionOfSecondaryDiagnol).getSymbol();
        boolean secondaryDiagnolCheck = true;

        for(int row = 2; row<= gridSize; row++){
            int primaryDiagnolPosition = getBoxPosition(row,row);
            int secondaryDiagnolPosition = getBoxPosition(row, gridSize - row+1);
            if(primaryDiagnolChar != boxes.get(primaryDiagnolPosition).getSymbol()){
                primaryDiagnolCheck = false;
            }
            if(secondaryDiagnolChar != boxes.get(secondaryDiagnolPosition).getSymbol()){
                secondaryDiagnolCheck = false;
            }

        }
        if(primaryDiagnolCheck){
            return primaryDiagnolChar;
        }
        if(secondaryDiagnolCheck){
            return secondaryDiagnolChar;
        }

        return '-';
    }


    public void printBoard(int gridSize, List<Box> boxes){
        for(int i = 1; i<= gridSize; i++){
            String rowContent = "";
            for(int j=1; j<= gridSize; j++){
                int position = getBoxPosition(i,j);
                char character = boxes.get(position).getSymbol();
                rowContent += character + " ";
            }
            System.out.println(rowContent);
        }
    }

    public void makeMove(int row, int col, List<Box> boxes, char symbol){
        int position = getBoxPosition(row, col);
        boxes.get(position).setSymbol(symbol);
        boxes.get(position).setOccupied(true);
    }
}
