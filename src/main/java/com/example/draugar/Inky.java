package com.example.draugar;



public class Inky extends Draugar {
    public Inky(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        super(draugar, elta, p, a, b, home);
    }

    public double drauaReikniritd(double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                double[] stefna = getP().Hnit();
                double att = getP().getStefna() / 90;
                if (att == 90) {
                    stefna[1] += 2;
                } else if (att == 180) {
                    stefna[0] -= 2;
                } else if (att == 270) {
                    stefna[1] -= 2;
                } else {
                    stefna[0] += 2;
                }
                double[] d = getBlinky().Hnit();
                double[] mismunnur = new double[2];
                for (int i = 0; i < mismunnur.length; i++) {
                    mismunnur[i] = stefna[i] - d[i];
                }
                for (int i = 0; i < stefna.length; i++) {
                    stefna[i] -= mismunnur[i];
                }
                return reknirit(a, stefna);
            } else {
                return ToHomeBaes(a);
            }

        } else {
            return home(a);
        }
    }
}
