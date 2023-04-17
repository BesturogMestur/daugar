package com.example.draugar;

public class Pinky extends Draugar {
    private final double[] HOME_BASE;

    public Pinky(boolean e, Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(e, p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd (double[] a) {
        if (!etan) {
            if (elta) {
                double[] stefna = p.Hnit();
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
