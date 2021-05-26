package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

public class Main extends Application {

    public static Stage acceuil;
    public static Stage main;
    public static Game game;

    @Override
    public void start(Stage ps) throws Exception{
        game = new Game();
        main = new Stage();
        Parent mainRoot = FXMLLoader.load(getClass().getResource("../ressource/main.fxml"));
        main.setTitle("Zombie Dice");
        main.setScene(new Scene(mainRoot,900,700));
        Parent root = FXMLLoader.load(getClass().getResource("../ressource/acceuil.fxml"));
        this.acceuil = ps;
        acceuil.setTitle("Acceuil");
        acceuil.setScene(new Scene(root, 900, 700));
        acceuil.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
