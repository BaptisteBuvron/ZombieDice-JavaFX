package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private Label dice1;

    @FXML
    private Label dice2;

    @FXML
    private Label dice3;

    @FXML
    private ImageView color1;

    @FXML
    private ImageView color2;

    @FXML
    private ImageView color3;

    @FXML
    private Label namePlayer;

    @FXML
    private ImageView diceChoose1;

    @FXML
    private ImageView diceChoose2;

    @FXML
    private ImageView diceChoose3;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
