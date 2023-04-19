package com.example.draugar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication {

    public static void main(String[] args) {
        PacmanMaze maze= new PacmanMaze();
        int a;
        while (maze.game_not_over){
            maze.pacmanAfram();
            maze.aframDraugar();
            maze.render();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}