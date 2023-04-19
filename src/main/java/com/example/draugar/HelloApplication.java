package com.example.draugar;

import java.util.Scanner;


public class HelloApplication {
    public static void main(String[] args) {
        PacmanMaze maze = new PacmanMaze();
        Scanner s = new Scanner(System.in);
        while (maze.game_not_over) {
            char a = s.next().charAt(0);
            maze.orvatakkar(a);
            maze.pacmanAfram();
            maze.aframDraugar();
            maze.render();


        }
    }
}