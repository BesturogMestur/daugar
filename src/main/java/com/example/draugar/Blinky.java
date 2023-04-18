package com.example.draugar;



public class Blinky extends Draugar {
    private final int[] HOME_BASE;
    public Blinky(boolean elta, Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(elta, p, a, b, home);
        HOME_BASE=homeBase;
    }
    public int drauaReikniritd (int[] a) {
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
