package tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static tictactoe.Main.GameBoard;
public class Start {

    public TextField player1;
    public TextField player2;

    public void initiategame(ActionEvent actionEvent){
        GameBoard = new Board(new Player(player1.getText(),0), new Player(player2.getText(), 0));
        Parent newstage = null;
        try {
            newstage = FXMLLoader.load(getClass().getResource("maininterface.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene nextscene = new Scene(newstage,600,400);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Tic-Tac-Toe");
        window.setScene(nextscene);
        window.show();
    }
}
