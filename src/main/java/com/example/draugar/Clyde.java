package com.example.draugar;
import javafx.scene.shape.Circle;

import java.util.Random;


public class Clyde extends Draugur {

    private Pacman p;



    public Clyde( Pacman p) {
       this.p = p;
       elta=true;

    }

    private double clyde() {
        double[] a = getHint();
        double[] stefna = p.getHint();
        double[] radius = new double[2];
        for (int i = 0; i < radius.length; i++) {
            radius[i] = stefna[i] - a[i];
        }
        if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) == 8) {
            return 0; //munn gera flýja sena
        }
        return hreyfing(getHint(), p.getHint());
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }

    public void afarm() {

    }

    public void render(){

    }
}
