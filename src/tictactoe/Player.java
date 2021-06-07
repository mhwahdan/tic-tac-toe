package tictactoe;

public class Player {
    private String name;
    private int Score;

    public Player() {
    }

    public Player(String name, int score) {
        this.name = name;
        Score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Player " + "name : " + name + "\nScore : " + Score;
    }
}
