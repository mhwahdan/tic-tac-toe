package tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import static tictactoe.Main.GameBoard;

public class MainInterface {
    public Text box_00;
    public Text box_01;
    public Text box_02;
    public Text box_10;
    public Text box_11;
    public Text box_12;
    public Text box_20;
    public Text box_21;
    public Text box_22;
    public Label player1;
    public Label player2;

    @FXML
    public void initialize()
    {
        player1.setText("player 1 :-\n" + GameBoard.getPlayer1().toString());
        player2.setText("player 1 :-\n" + GameBoard.getPlayer2().toString());
        box_00.setText("");
        box_01.setText("");
        box_02.setText("");
        box_10.setText("");
        box_11.setText("");
        box_12.setText("");
        box_20.setText("");
        box_21.setText("");
        box_22.setText("");
    }

    public void playturn(MouseEvent mouseEvent){
        String id = ((Text)mouseEvent.getSource()).getId();
        boolean isfinished = false;
        Player winner;
        switch (id)
        {
            case "box_00":
                if(box_00.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(0,0);
                box_00.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_01":
                if(box_01.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(0,1);
                box_01.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_02":
                if(box_02.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(0,2);
                box_02.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_10":
                if(box_10.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(1,0);
                box_10.setText(GameBoard.getTurnCounter() % 2 == 1? "X" : "O");
                break;
            case "box_11":
                if(box_11.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(1,1);
                box_11.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_12":
                if(box_12.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(1,2);
                box_12.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_20":
                if(box_20.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(2,0);
                box_20.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_21":
                if(box_21.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(2,1);
                box_21.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            case "box_22":
                if(box_22.getText() != "")
                    return;
                isfinished = GameBoard.PlayTurn(2,2);
                box_22.setText(GameBoard.getTurnCounter()%2 == 1? "X" : "O");
                break;
            default:
                return;
        }
        if(isfinished) {
            winner = GameBoard.GetPlayerTurn();
            Alert win = new Alert(Alert.AlertType.CONFIRMATION);
            win.setTitle("We have a winner !!!");
            winner.setScore(winner.getScore() + 1);
            win.setContentText(winner.toString());
            GameBoard.ResetBoard();
            win.showAndWait();
            initialize();
        }
        if(GameBoard.getTurnCounter() == 9)
        {
            Alert win = new Alert(Alert.AlertType.CONFIRMATION);
            win.setTitle("Draw !!!");
            win.setContentText("Draw !!!");
            GameBoard.ResetBoard();
            win.showAndWait();
            initialize();
        }
    }
}
