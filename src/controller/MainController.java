package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
import model.Cup;
import model.Dice;
import model.Player;
import tools.DiceFaces;
import tools.Difficulty;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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

    @FXML
    private ImageView colorChoose1;

    @FXML
    private ImageView colorChoose2;

    @FXML
    private ImageView colorChoose3;

    @FXML
    private Label scoreBrain;

    @FXML
    private Label scoreShotGun;

    @FXML
    private Label score1;

    @FXML
    private Label score2;

    @FXML
    private Label score3;

    @FXML
    private Label score4;

    @FXML
    private Label score5;

    private ArrayList<Label> scores = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.main.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                start();
            }
        });
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        scores.add(score4);
        scores.add(score5);
    }

    public void start() {

        Cup cup = new Cup();
        switch (Main.game.getDifficulty()) {
            case EASY:
                for (int i = 1; i <= 13; i++) {
                    if (i <= 8) {
                        cup.addDice(new Dice("green"));
                    } else if (i <= 11) {
                        cup.addDice(new Dice("yellow"));
                    } else {
                        cup.addDice(new Dice("red"));
                    }
                }
                dice1.setText("8");
                dice2.setText("3");
                dice3.setText("2");

                break;
            case MEDIUM:
                for (int i = 1; i <= 13; i++) {
                    if (i <= 6) {
                        cup.addDice(new Dice("green"));
                    } else if (i <= 10) {
                        cup.addDice(new Dice("yellow"));
                    } else {
                        cup.addDice(new Dice("red"));
                    }
                }
                dice1.setText("6");
                dice2.setText("4");
                dice3.setText("3");
                break;
            case HARD:
                System.out.println("Difficile");
                Main.game.setDifficulty(Difficulty.HARD);
                for (int i = 1; i <= 13; i++) {
                    if (i <= 4) {
                        cup.addDice(new Dice("green"));
                    } else if (i <= 9) {
                        cup.addDice(new Dice("yellow"));
                    } else {
                        cup.addDice(new Dice("red"));
                    }
                }
                dice1.setText("4");
                dice2.setText("5");
                dice3.setText("4");
                break;
        }
        Main.game.setCup(cup);
        initPlayer();
    }

    public void initPlayer() {
        scoreBoard();
        namePlayer.setText("Player : " + Main.game.getCurrentPlayer().getName());
        scoreBrain.setText(String.valueOf(Main.game.getCurrentPlayer().getScore()));
        scoreShotGun.setText(Main.game.getCurrentPlayer().getnGun().toString());
        if (Main.game.getCurrentPlayer().getnGun() >= 3 || Integer.parseInt(scoreBrain.getText()) + Main.game.getCurrentPlayer().getNbrain() >= 13) {
            changePlayer();
        }
    }

    @FXML
    public void changePlayer() {
        System.out.println("Change player");
        if (Integer.parseInt(scoreBrain.getText()) + Main.game.getCurrentPlayer().getNbrain() >= 13) {
            Main.game.getCurrentPlayer().addBrains(Main.game.getCurrentPlayer().getScore());
            scoreBoard();
            System.out.println("Victoire du joueur : " + Main.game.getCurrentPlayer().getName());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victoire !");
            alert.setHeaderText("");
            alert.setContentText("Victoire du joueur " + Main.game.getCurrentPlayer().getName());
            alert.showAndWait();
        } else {
            if (Main.game.getCurrentPlayer().getnGun() < 3) {
                System.out.println("Ajouter score");
                Main.game.getCurrentPlayer().addBrains(Main.game.getCurrentPlayer().getScore());
            } else {
                System.out.println("3 fusils à pompe");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fusil à pompe");
                alert.setHeaderText("Vous avez eu 3 fusils à pompe.");
                alert.setContentText("Vous perdez les cerveaux de ce tour.\n C'est le tour du joueur suivant.");
                alert.showAndWait();
            }
            Main.game.getCurrentPlayer().setScore(0);
            Main.game.getCurrentPlayer().setnGun(0);
            Main.game.changePlayer();
            initPlayer();

        }


    }

    @FXML
    public void launchDice() {
        if (Integer.parseInt(scoreBrain.getText()) + Main.game.getCurrentPlayer().getNbrain() >= 13 || Integer.parseInt(scoreShotGun.getText()) >= 3) {
            changePlayer();
        } else {

            Object[] dice1 = Main.game.getCup().getADice(0);
            Object[] dice2 = Main.game.getCup().getADice(1);
            Object[] dice3 = Main.game.getCup().getADice(2);
            if (dice1 == null || dice2 == null || dice3 == null) {
                changePlayer();
            } else {
                changeDisplayDice(diceChoose1, colorChoose1, dice1);
                changeDisplayDice(diceChoose2, colorChoose2, dice2);
                changeDisplayDice(diceChoose3, colorChoose3, dice3);
            }

        }

    }

    public void changeDisplayDice(ImageView imageDice, ImageView imageColor, Object[] dice) {
        switch ((DiceFaces) dice[0]) {
            case brain:
                imageDice.setImage(new Image("ressource/images/brain.png"));
                Main.game.getCurrentPlayer().addScore();
                break;
            case steps:
                imageDice.setImage(new Image("ressource/images/emprunte.png"));
                break;
            case shotgun:
                imageDice.setImage(new Image("ressource/images/shotgun.png"));
                Main.game.getCurrentPlayer().addGun();
                break;
        }

        switch ((String) dice[1]) {
            case "green":
                imageColor.setImage(new Image("ressource/images/dice_green.png"));
                break;
            case "yellow":
                imageColor.setImage(new Image("ressource/images/dice_yellow.png"));
                break;
            case "red":
                imageColor.setImage(new Image("ressource/images/dice_red.png"));
                break;
        }
        initPlayer();
    }

    public void scoreBoard(){
        int numberPlayer = Main.game.getnPlayer()-1;
        ArrayList<Player> players = new ArrayList<>();
        players.addAll(Main.game.getPlayers());
        Collections.sort(players);
        int i =0;
        for (Label l:scores) {
            if (i <= numberPlayer){
                l.setVisible(true);
                l.setText((i+1)+" - " + players.get(i).getName() + " : " + players.get(i).getNbrain());
            }else {
                l.setVisible(false);
            }
            i++;
        }
    }
}
