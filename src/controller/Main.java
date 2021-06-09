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
    public static Game game = new Game();

    @Override
    public void start(Stage ps) throws Exception{
        main = new Stage();
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/ressource/main.fxml"));
        main.setTitle("Zombie Dice");
        Scene scene = new Scene(mainRoot,1300,570);
        main.setScene(scene);
        main.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/ressource/acceuil.fxml"));
        this.acceuil = ps;
        acceuil.setTitle("Acceuil");
        acceuil.setScene(new Scene(root, 900, 570));
        acceuil.setResizable(false);
        acceuil.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
