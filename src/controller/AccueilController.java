package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Cup;
import model.Dice;
import tools.Difficulty;
import model.Player;

public class AccueilController {

    @FXML
    private ToggleGroup difficulté;

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
        if (nPlayer >= 2 || nPlayer <= 5 && nPlayer != null) {
            Main.game.setnPlayer(nPlayer);
        } else {
            error.setText("Nombre de joueur incorrect");
        }
    }

    public void validNamePlayer(ActionEvent event) {
        if (Main.game.getnPlayer() != null) {

            if (listNamePlayer.getItems().size() != Main.game.getnPlayer() && namePlayer.getText().length() >= 1 && namePlayer.getText() != null) {
                listNamePlayer.getItems().add(namePlayer.getText());
                Main.game.addPlayer(new Player(namePlayer.getText()));

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
            Cup cup = new Cup();
            switch (((RadioButton)difficulté.getSelectedToggle()).getText()){
                case "Facile":
                    System.out.println("facile");
                    Main.game.setDifficulty(Difficulty.EASY);
                    for (int i = 1; i <= 13; i++) {
                        if (i <= 8){
                            cup.addDice(new Dice("green"));
                        }
                        else if(i <=11){
                            cup.addDice(new Dice("yellow"));
                        }
                        else {
                            cup.addDice(new Dice("red"));
                        }
                    }
                    break;
                case "Moyen":
                    System.out.println("Moyen");
                    Main.game.setDifficulty(Difficulty.MEDIUM);
                    for (int i = 1; i <= 13; i++) {
                        if (i <= 6){
                            cup.addDice(new Dice("green"));
                        }
                        else if(i <=10){
                            cup.addDice(new Dice("yellow"));
                        }
                        else {
                            cup.addDice(new Dice("red"));
                        }
                    }
                    break;
                case "Difficile":
                    System.out.println("Difficile");
                    Main.game.setDifficulty(Difficulty.HARD);
                    for (int i = 1; i <= 13; i++) {
                        if (i <= 4){
                            cup.addDice(new Dice("green"));
                        }
                        else if(i <=9){
                            cup.addDice(new Dice("yellow"));
                        }
                        else {
                            cup.addDice(new Dice("red"));
                        }
                    }
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
