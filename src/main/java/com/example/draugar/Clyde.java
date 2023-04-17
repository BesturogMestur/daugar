package com.example.draugar;


public class Clyde extends Draugar {
    private final double[] HOME_BASE;

    public Clyde(boolean e, Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(e, p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd(double[] a) {
        if (!etan) {
            if (elta) {
                double[] stefna = p.Hnit();
                double[] stadSeting =this.Hnit();
                double[] radius = new double[2];
                for (int i = 0; i < radius.length; i++) {
                    radius[i] = stefna[i] - stadSeting[i];
                    if (radius[i] < 0) {
                        radius[i] *= -1;
                    }
                }
                if (Math.pow(radius[0], 2) + Math.pow(radius[1], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);

                } else if (radius[0] == 0 && radius[0] + Math.pow(radius[1], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);

                } else if (radius[1] == 0 && radius[1] + Math.pow(radius[0], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);
                }

                return ToPac(a);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }


        } else {
            return home(a);
        }
    }
}
