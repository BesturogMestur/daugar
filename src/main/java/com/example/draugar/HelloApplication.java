package com.example.draugar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication {

    public static void main(String[] args) {
        PacmanMaze maze= new PacmanMaze();
        while (true){
            maze.pacmanAfram();
            maze.aframDraugar();
            maze.render();
        }
    }
}