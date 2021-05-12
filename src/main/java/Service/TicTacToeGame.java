package Service;

import Model.Box;
import Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToeGame {
    private int numberOfPlayers;
    private int gridSize;
    private int turn;
    private boolean gameEnded;
    private List<Player> players;
    private List<Box> boxes;
    private TicTacToeHelper ticTacToeHelper;

    public TicTacToeGame(int numberOfPlayers, int gridSize, List<Player> players) {
        this.numberOfPlayers = numberOfPlayers;
        this.gridSize = gridSize;
        this.players = players;
        List<Box> boxes = new ArrayList<>();
        for(int row = 1; row<=gridSize; row++){
            for(int col = 1; col <= gridSize; col++){
                Box box = new Box(row, col, '-', false);
                boxes.add(box);
            }
        }
        this.boxes = boxes;
        this.gameEnded = false;
        this.turn = 0;

        this.ticTacToeHelper = new TicTacToeHelper();

    }

    public void playMove(String rowString, String colString){

        if(rowString.equals("exit")){
            setGameEnded(true);
            return;
        }

        int row = Integer.parseInt(rowString);
        int col = Integer.parseInt(colString);
        int turn = getTurn();
        int numberOfPlayers = getNumberOfPlayers();
        Player currentPlayer = getPlayers().get(turn);
        char playerCharacter = currentPlayer.getAllottedCharacter();
        String playerName = currentPlayer.getName();
        int gridSize = getGridSize();
        List<Box> boxes = getBoxes();
        boolean isInvalid = getTicTacToeHelper().isMoveInvalid(row, col, gridSize, boxes);
        if(isInvalid){
           handleInvalidMove();
           return;
        }

        System.out.println(playerName + " has  played " + playerCharacter + " at row: "+row +" col: "+col);
        getTicTacToeHelper().makeMove(row,col,boxes,playerCharacter);

        char winnerSymbol = getTicTacToeHelper().getWinnerSymbol(getGridSize(), boxes);
        Player winner = getTicTacToeHelper().findWinner(winnerSymbol, getPlayers());
        if(!Objects.isNull(winner)){
            setGameEnded(true);
            winner.setHasWon(true);
            displayWinner(winner);
            return;
        }

        setTurn((turn + 1) % numberOfPlayers);
    }

    public void handleInvalidMove(){
        String message = " Invalid move. Please make a valid move";
        System.out.println(message);
    }

    public void displayWinner(Player winner){
        String message = " Player "+winner.getName()+" has won";
        System.out.println(message);
    }

    public void displayBoard(){
        getTicTacToeHelper().printBoard(getGridSize(), getBoxes());
    }


    public TicTacToeHelper getTicTacToeHelper() {
        return ticTacToeHelper;
    }

    public void setTicTacToeHelper(TicTacToeHelper ticTacToeHelper) {
        this.ticTacToeHelper = ticTacToeHelper;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
}
