package com.example.draugar;



public class Blinky extends Draugar {
    public Blinky(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        super(draugar, elta, p, a, b, home);
    }
    public double drauaReikniritd (double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                return ToPac(a);
            } else {
                return ToHomeBaes(a);
            }

        } else {
            return home(a);
        }
    }
}
