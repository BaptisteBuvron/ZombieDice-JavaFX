package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import tools.Difficulty;
import model.Player;

public class AccueilController {

    @FXML
    private ToggleGroup difficulte;

    @FXML
    private TextField numberPlayer;

    @FXML
    private Button validNPlayer;

    @FXML
    private TextField namePlayer;

    @FXML
    private Button validNamePlayer;

    @FXML
    private Label error;

    @FXML
    private ListView listNamePlayer;

    @FXML
    private Button play;


    public void validNPlayer(ActionEvent event) {
        Integer nPlayer = Integer.parseInt(numberPlayer.getText());
        if (nPlayer > 5 || nPlayer < 2 || nPlayer == null) {
            error.setText("Nombre de joueur incorrect");
        } else {
            Main.game.setnPlayer(nPlayer);
            error.setText("");
        }
    }

    public void validNamePlayer(ActionEvent event) {
        if (Main.game.getnPlayer() != null) {

            if (listNamePlayer.getItems().size() != Main.game.getnPlayer() && namePlayer.getText().length() >= 1 && namePlayer.getText() != null) {
                listNamePlayer.getItems().add(namePlayer.getText());
                Main.game.addPlayer(new Player(namePlayer.getText()));
                error.setText("");

            }
            else {
                error.setText("Vous avez saisie les noms de tous les joueurs");
            }
        }
        else {
            error.setText("Veuillez choisir un nombre de joueur");
        }
    }

    public void play(ActionEvent event){

        if (Main.game.getnPlayer() != null && Main.game.getPlayers().size() == Main.game.getnPlayer()){
            switch (((RadioButton) difficulte.getSelectedToggle()).getText()){
                case "Facile":
                    System.out.println("facile");
                    Main.game.setDifficulty(Difficulty.EASY);
                    break;
                case "Moyen":
                    System.out.println("Moyen");
                    Main.game.setDifficulty(Difficulty.MEDIUM);
                    break;
                case "Difficile":
                    System.out.println("Difficile");
                    Main.game.setDifficulty(Difficulty.HARD);
                    break;
            }








            Main.acceuil.close();
            Main.main.show();
        }
        else {
            error.setText("Vous n'avez pas saisie les noms des joueurs ou le nombre de joueurs.");
        }



    }


}
