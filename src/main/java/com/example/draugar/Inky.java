package com.example.draugar;



public class Inky extends Draugar {
    private final int[] HOME_BASE;
    private Draugar blinky;

    public Inky(boolean e, Pacman p, int[] a, int[] b, int[] home, int[] homeBase, Draugar blinky) {
        super(e, p, a, b, home);
        this.blinky = blinky;
        HOME_BASE = homeBase;

    }

    public int drauaReikniritd(int[] a) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.Hnit();
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
                int[] d = blinky.Hnit();
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
