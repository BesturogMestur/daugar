package com.example.draugar;

public class Pinky extends Draugar {
    private final int[] HOME_BASE;

    public Pinky(boolean e, Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(e, p, a, b, home);
        HOME_BASE = homeBase;
    }

    public int drauaReikniritd (int[] a) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.Hnit();
                double att = p.getStefna();
                if (att == 90) {
                    stefna[1] += 4;
                } else if (att == 180) {
                    stefna[0] -= 4;
                } else if (att == 270) {
                    stefna[1] -= 4;
                } else {
                    stefna[0] += 4;
                }
                return reknirit(a,stefna);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }

}
