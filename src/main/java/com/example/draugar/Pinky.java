package com.example.draugar;

public class Pinky extends Draugar {
    public Pinky(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        super(draugar, elta, p, a, b, home);
    }

    public double drauaReikniritd (double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                double[] stefna = getP().Hnit();
                double att = getP().getStefna();
                if (att == 90) {
                    stefna[1] += 4;
                } else if (att == 180) {
                    stefna[0] -= 4;
                } else if (att == 270) {
                    stefna[1] -= 4;
                } else {
                    stefna[0] += 4;
                }
                return ToPac(a);
            } else {
                return ToHomeBaes(a);
            }

        } else {
            return home(a);
        }
    }

}
