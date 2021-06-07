package tictactoe;

import java.util.Arrays;

public class Board implements BoardActions{
    private char[][] BoardMatrix;
    private int TurnCounter;
    private Player player1;
    private Player player2;

    public Board() {
        this.TurnCounter = 0;
        this.BoardMatrix = new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.TurnCounter = 0;
        this.BoardMatrix = new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
    }

    public Board(char[][] boardMatrix,int TurnCounter, Player player1, Player player2) {
        BoardMatrix = boardMatrix;
        this.player1 = player1;
        this.player2 = player2;
        this.TurnCounter = TurnCounter;
    }

    public char[][] getBoardMatrix() {
        return BoardMatrix;
    }

    public void setBoardMatrix(char[][] boardMatrix) {
        BoardMatrix = boardMatrix;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getTurnCounter() {
        return TurnCounter;
    }

    @Override
    public Boolean PlayTurn(int LocationX, int LocationY) {
        if (this.TurnCounter % 2 == 1)
            this.BoardMatrix[LocationX][LocationY] = 'x';
        else if(this.TurnCounter % 2 == 0)
            this.BoardMatrix[LocationX][LocationY] = 'O';
        this.TurnCounter++;
        //check rows
        for(int i = 0; i < 3; i++)
            if(this.BoardMatrix[i][0] == this.BoardMatrix[i][1] && this.BoardMatrix[i][0] == this.BoardMatrix[i][2] && this.BoardMatrix[i][0] != ' ')
                return true;
        //check columns
        for(int i = 0; i < 3; i++)
            if(this.BoardMatrix[0][i] == this.BoardMatrix[1][i] && this.BoardMatrix[0][i] == this.BoardMatrix[2][i] && this.BoardMatrix[0][i] != ' ')
                return true;
        //check diagonals
        if(this.BoardMatrix[0][0] == this.BoardMatrix[1][1] && this.BoardMatrix[0][0] == this.BoardMatrix[2][2] && this.BoardMatrix[0][0] != ' ')
            return true;
        //check anti-diagonal
        if(this.BoardMatrix[0][2] == this.BoardMatrix[1][1] && this.BoardMatrix[0][2] == this.BoardMatrix[2][0] && this.BoardMatrix[0][2] != ' ')
            return true;
        return false;
    }

    @Override
    public int[] PlayerPoints() {
        return new int[]{player1.getScore(), player2.getScore()};
    }

    @Override
    public Player GetPlayerTurn() {
        if (this.TurnCounter % 2 == 1)
            return this.player1;
        else if(this.TurnCounter % 2 == 0)
            return this.player2;
        return null;
    }

    @Override
    public void ResetBoard() {
        this.TurnCounter = 0;
        this.BoardMatrix = new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
    }

    @Override
    public String toString() {
        String matrix = "";

        for(int i = 0; i < 3; i++)
            matrix += "\n " + this.BoardMatrix[i][0] + " | " + this.BoardMatrix[i][1] + " | " + this.BoardMatrix[i][2] + '\n';


        return this.GetPlayerTurn().getName() + " turn " + matrix;
    }
}
