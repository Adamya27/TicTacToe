package Model;

public class Player {
    private String name;
    private char allottedCharacter;
    private boolean hasWon;

    public Player(String name, char allottedCharacter) {
        this.name = name;
        this.allottedCharacter = allottedCharacter;
        this.hasWon = false;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getAllottedCharacter() {
        return allottedCharacter;
    }

    public void setAllottedCharacter(char allottedCharacter) {
        this.allottedCharacter = allottedCharacter;
    }
}
