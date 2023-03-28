package com.example.draugar;

import javafx.scene.shape.Circle;

public abstract class Draugur extends Circle {

    private boolean hraedir = false;
    public boolean elta;
    public abstract void afarm();
    public abstract void render();


    public int hreyfing(double[] d, double[] stefna){
        return (int)(Math.pow(d[0]-stefna[0],2)+Math.pow(d[0]-stefna[0],2));
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }

    public void setHredir(boolean hraedir) {
        this.hraedir = hraedir;
    }

    public void setElta(boolean elta) {
        this.elta = elta;
    }
}
