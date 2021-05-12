package Model;

public class Box {
    private int row;
    private int column;
    private char symbol;
    private boolean isOccupied;

    public Box(int row, int column, char symbol, boolean isOccupied) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
        this.isOccupied = isOccupied;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
