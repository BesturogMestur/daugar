package com.example.draugar;



public class Inky extends Draugar {
    private final double[] HOME_BASE;
    private Blinky blinky;

    public Inky(boolean e, Pacman p, double[] a, double[] b, double[] home, double[] homeBase, Blinky blinky) {
        super(e, p, a, b, home);
        this.blinky = blinky;
        HOME_BASE = homeBase;

    }

    public double drauaReikniritd(double[] a) {
        if (!etan) {
            if (elta) {
                double[] stefna = p.Hnit();
                double att = p.getStefna() / 90;
                if (att == 90) {
                    stefna[1] += 2;
                } else if (att == 180) {
                    stefna[0] -= 2;
                } else if (att == 270) {
                    stefna[1] -= 2;
                } else {
                    stefna[0] += 2;
                }
                double[] d = blinky.Hnit();
                double[] mismunnur = new double[2];
                for (int i = 0; i < mismunnur.length; i++) {
                    mismunnur[i] = stefna[i] - d[i];
                }
                for (int i = 0; i < stefna.length; i++) {
                    stefna[i] -= mismunnur[i];
                }
                return reknirit(a, stefna);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
