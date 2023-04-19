package com.example.draugar;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

public class PacmanMaze extends GridPane {

    public boolean game_not_over=true;
    private final int[] HOME = {6, 5};
    private final int[] UPPHAFS_PUNKTUR = {0, 0};
    private final int[] MESTA_LEGNT_FRA_UPPHAF = {13, 12};
    private final int[] BLINKY_HOME = {13, 0};
    private final int[] CLYDE_HOME = {0, 12};
    private boolean[][] maze = {
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, false, false, true, false, false, false, true, false, false, true, false},
            {false, true, false, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, true, false, true, false, false, false, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, true, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, false, false, false, true, false, true, false},
            {false, true, false, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, false, false, true, false, false, false, true, false, false, true, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false}};

    private String[][] rend=new String[13][14];
    private final int[] TIMAR = {10, 8, 10, 2};
    private int havdaTimi = 0;
    private int timi;
    @FXML
    private Pacman fxPacman;
    private Draugar blinky;
    private Draugar inky;
    private Draugar pinky;
    private Draugar clyde;
    private HashMap<KeyCode, Double> map = new HashMap<>();


    public PacmanMaze() {
        nyrLeikur();
    }


    public void nyrLeikur() {
        setPecman(6, 10);
        timi = TIMAR[havdaTimi];
        setDraugar();
    }

    public void orvatakkar(char a) {
        if(a=='a'){
            fxPacman.setRotate(180);
        }if(a=='s'){
            fxPacman.setRotate(270);
        }if(a=='d'){
            fxPacman.setRotate(0);
        }if (a=='w'){
            fxPacman.setRotate(90);
        }
    }



    private void setPecman(int x, int y) {
        fxPacman = new Pacman();
        fxPacman.setCenterX(x);
        fxPacman.setCenterY(y);
    }

    private void setDraugar() {
        blinky = new Blinky(true, fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        blinky.setCenterX(1);
        blinky.setCenterY(1);

        inky = new Inky(true, fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        inky.setCenterX(6);
        inky.setCenterY(1);

        pinky = new Pinky(true, fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        pinky.setCenterX(1);
        pinky.setCenterY(10);

        clyde = new Clyde(true, fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);
        clyde.setCenterX(10);
        clyde.setCenterY(10);

    }


    /**
     * þesso aferð tekur in kommu tölu og stillir síðan stfnu þess á botaum.
     *
     * @param d Kommu tala
     */
    public void setStefna(Double d) {
        fxPacman.setRotate(d);
    }

    public void pacmanAfram() {
        fxPacman.afarm(walls(fxPacman.Hnit()));
    }


    public void aframDraugar() {
        aframDurgar(blinky);
        aframDurgar(inky);
        aframDurgar(pinky);
        aframDurgar(clyde);
        if (timi <= 0) {
            uppfraeraTima();
        }
    }

    private void aframDurgar(Draugar d) {
        int[] a = d.Hnit();

        if (timi <= 0) {
            if (d.elta) {
                d.setElta(false);
            } else {
                d.setElta(true);
            }
        }
        if (a[0] == 6 && a[1] == 5) {
            d.setEtan(false);
            d.setRotate(90);
        }


        d.afarm(walls(d.Hnit()));
        athugaPacman(d);
    }




    private boolean[] walls(int[] a) {
        boolean[] walls = new boolean[4];

        for (int i = 0; i < walls.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    walls[i] = maze[a[0]][a[1] - 1];
                } else {
                    walls[i] = maze[a[0]][a[1] + 1];
                }

            } else {
                if (i == 1) {
                    walls[i] = maze[a[0] - 1][a[1]];
                } else {
                    walls[i] = maze[a[0] + 1][a[1]];
                }
            }
        }
        return walls;

    }

    private void athugaPacman(Draugar d) {
        if (d.getBoundsInParent().intersects(fxPacman.getBoundsInParent())) {
            if (!d.hraedir && !d.etan) {
                game_not_over=false;
            } else if (d.hraedir) {
                d.setEtan(true);
            }
        }
    }

    private void uppfraeraTima() {
        havdaTimi++;
        if (havdaTimi >= TIMAR.length) {
            havdaTimi = 0;
        }
        timi = TIMAR[havdaTimi];
    }

//--------------RENDER------------------------------------------------------
    private  void setRend(){
        for (int i=0; i<13; i++)
            for (int k=0; k<14; k++){
                rend[i][k]="##";
                if (maze[i][k])
                    rend[i][k]="  ";
            }

    }

    public void render(){
        setRend();
        int x,y;
        x=(int)fxPacman.getCenterX();
        y=(int)fxPacman.getCenterY();
        rend[x][y]="PP";

        x=(int)blinky.getCenterX();
        y=(int)blinky.getCenterY();
        rend[x][y]="bb";

        x=(int)pinky.getCenterX();
        y=(int)pinky.getCenterY();
        rend[x][y]="pp";

        x=(int)inky.getCenterX();
        y=(int)inky.getCenterY();
        rend[x][y]="ii";

        x=(int)clyde.getCenterX();
        y=(int)clyde.getCenterY();
        rend[x][y]="cc";

        for (int i=0; i<14; i++) {
            for (int k = 0; k < 13; k++) {
                System.out.print(rend[k][i]);
            }
            System.out.println();


        }

        if (!game_not_over){
            System.out.println("Game Over");
        }

/*
        System.out.println("Packman x= "+fxPacman.getCenterX()+", y="+fxPacman.getCenterY());
        System.out.println("Blinky  x= "+blinky.getCenterX()+", y="+blinky.getCenterY());
        System.out.println("Pinky   x= "+pinky.getCenterX()+", y="+pinky.getCenterY());
        System.out.println("Inky    x= "+inky.getCenterX()+", y="+inky.getCenterY());
        System.out.println("Clyde   x= "+clyde.getCenterX()+", y="+clyde.getCenterY());

        System.out.println();
        System.out.println();
        System.out.println();
*/
    }

}



