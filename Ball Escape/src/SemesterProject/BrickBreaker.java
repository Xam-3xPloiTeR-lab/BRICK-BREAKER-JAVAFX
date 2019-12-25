/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemesterProject;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Xam 3xPloiTeR
 */
public class BrickBreaker extends Application{
    
    @Override
    public void start(Stage primaryStage) {
     Game game = new Game();
     game.run(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
