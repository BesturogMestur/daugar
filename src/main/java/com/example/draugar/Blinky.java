package com.example.draugar;



public class Blinky extends Draugar {
    private final double[] HOME_BASE;
    public Blinky(boolean elta, Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(elta, p, a, b, home);
        HOME_BASE=homeBase;
    }
    public double drauaReikniritd (double[] a) {
        if (!etan) {
            if (elta) {
                return ToPac(a);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
