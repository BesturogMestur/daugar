package com.example.draugar;

import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Draugar extends Circle implements Afram, Hnit {
    protected Pacman p;
    protected boolean elta = false;
    protected boolean etan = false;
    protected boolean hraedir = false;
    private final int OFFSET = 1;
    private Random random;
    private final double MAX_LEND;
    private final int[] HOME;

    public abstract int drauaReikniritd(int[] a);


    public Draugar(boolean elta, Pacman p, int[] a, int[] b, int[] home) {
        this.elta = elta;
        this.p = p;
        MAX_LEND = reknirit(a, b);
        HOME = home;
    }

    public void setHredir(boolean hraedir) {
        setRotate(turnAround());
        this.hraedir = hraedir;
    }

    public void setElta(boolean elta) {
        setRotate(turnAround());
        this.elta = elta;
    }

    public void setEtan(boolean etan) {
        if (hraedir) {
            hraedir = false;
        }
        this.etan = etan;
    }

    private double turnAround() {
        return (getRotate() + 180) % 360;
    }

    public int ToPac(int[] a) {
        return reknirit(a, p.Hnit());
    }

    public int ToHomeBaes(int[] a, int[] homeBase) {
        return reknirit(a, homeBase);
    }

    public int home(int[] a) {
        return reknirit(a, HOME);
    }

    public int[] Hnit() {
        int[] a = new int[2];
        a[0] = (int) getCenterX();
        a[1] = (int) getCenterY();
        return a;
    }

    public int reknirit(int[] d, int[] stefna) {
        double x = d[0] - stefna[0];
        double y = (d[1] - stefna[1]);
        if (x != 0) {
            if (x < 0) {
                x *= -1;
            }
            x = Math.pow(x, 2);
        }
        if (y != 0) {
            if (y < 0) {
                y *= -1;
            }
            y = Math.pow(y, 2);
        }
        int sum = (int) (x + y);
        return sum;
    }

    public int[] piontOfColuslson(int[] a, int i) {
        if (i % 2 == 0) {
            if (i == 0) {
                a[1] -= 1;
            } else {
                a[1] += 1;
            }
        } else {
            if (i == 1) {
                a[0] -= 1;
            } else {
                a[0] += 1;
            }
        }
        return a;
    }

    private void direson() {
        if (getRotate() == 90) {
            setCenterY(getCenterY() - 1);
        } else if (getRotate() == 180) {
            setCenterX(getCenterX() - 1);
        } else if (getRotate() == 270) {
            setCenterY(getCenterY() + 1);
        } else {
            setCenterX(getCenterX() + 1);
        }

    }

    @Override
    public void afarm(boolean[] path) {
        double bakvid = turnAround();
        double minLend = MAX_LEND;
        double lend = minLend;

        if (hraedir) {
            setRotate(random.nextInt(4));
            while (bakvid == getRotate()) {
                setRotate(random.nextInt(4));
                for (int i = 0; i < path.length; i++) {
                    if (getRotate() == (90 + (90 * i)) % 360 && !path[i]) {
                        setRotate(bakvid);
                        break;
                    }
                }
            }
            direson();
        } else {
            for (int i = 0; i < 4; i++) {
                double att = (90 + (90 * i)) % 360;

                if (bakvid != att && path[i]) {
                    int[] maeliStadur = Hnit();
                    maeliStadur = piontOfColuslson(maeliStadur, i);
                    lend = drauaReikniritd(maeliStadur);

                    if (lend < minLend) {
                        minLend = lend;
                        setRotate(att);
                    }
                }
            }
            direson();
        }
    }
}

