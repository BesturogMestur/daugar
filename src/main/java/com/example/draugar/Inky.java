package com.example.draugar;

import javafx.scene.shape.Circle;

import java.util.Random;

public class Inky extends  Draugur {

    private Pacman p;

    public Inky(Pacman p) {
        this.p = p;
    }

    private double inky() {
        return hreyfing(getHint(), p.getHint());
    }

    public void afarm(){

    }

    public void render(){

    }

}
