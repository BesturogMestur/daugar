package com.example.draugar;

import javafx.scene.shape.Circle;

import java.util.Random;

public class Pinky extends Draugur{

    private Pacman p;

    public Pinky( Pacman p) {
        this.p = p;
    }

    private double pinky() {
        double[] stefna = p.getHint();
        double att = p.getStefna();
        if (att == 0) {
            stefna[1] += 4;
        } else if (att == 1) {
            stefna[0] += 4;
        } else if (att == 2) {
            stefna[1] -= 4;
        } else {
            stefna[0] -= 4;
        }
        return hreyfing(getHint(), p.getHint());
    }
    public void afarm(){

    }
    public void render(){

    }
}
