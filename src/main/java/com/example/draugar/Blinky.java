package com.example.draugar;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Blinky extends Draugur{


    private Pacman p;
    Draugur inky;

    public Blinky( Pacman p, Draugur inky) {
        this.p = p;
        this.inky=inky;
    }

    private double blinky() {
        double[] stefna = p.getHint();
        double att = p.getStefna()/90;
        if (att == 0) {
            stefna[1] += 2;
        } else if (att == 1) {
            stefna[0] += 2;
        } else if (att == 2) {
            stefna[1] -= 2;
        } else {
            stefna[0] -= 2;
        }
        double[] d = this.inky.getHint();
        double[] mismunnur = new double[2];
        for (int i = 0; i < mismunnur.length; i++) {
            mismunnur[i] = stefna[i] - d[i];
        }
        for (int i = 0; i < stefna.length; i++) {
            stefna[i] -= mismunnur[i];
        }
        return hreyfing(getHint(), p.getHint());
    }

    public void afarm(){

    }
    public void render(){

    }
}
