package tictactoe;

public interface BoardActions {
    public abstract Boolean PlayTurn(int LocationX,int LocationY);
    public abstract int[] PlayerPoints();
    public abstract Player GetPlayerTurn();
    public abstract void ResetBoard();
}
