package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PinkyTest {
    private final double[] A = {0, 0};
    private final double[] B = {10, 10};
    private final double[] HOME = {6, 6};
    private final double[] HOME_BASE = {0, 0};
    private Pinky pinky;
    private Pacman pacman;

    @Before
    public void carateParameters() {
        pacman = new Pacman();
        pacman.setCenterX(6);
        pacman.setCenterY(0);

        pinky = new Pinky(true,pacman, A, B,HOME, HOME_BASE);
        pinky.setCenterX(6);
        pinky.setCenterY(6);
    }

    @Test
    public void testDrugaRikniritElta() {
        double[] a = {6, 5};
        assertEquals(41, (int) pinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(61, (int) pinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(65, (int) pinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(45, (int) pinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        pinky.setElta(false);

        double[] a = {6, 5};
        assertEquals(61, (int) pinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(61, (int) pinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(85, (int) pinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(85, (int) pinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten(){
        pinky.setEtan(true);

        double[] a = {6, 5};
        assertEquals(1, (int) pinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(1, (int) pinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(1, (int) pinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(1, (int) pinky.drauaReikniritd(d));
    }

    @Test
    public void testAfram(){
        boolean[] b = {false,true,false,true};

        pinky.setRotate(90);
        pinky.afarm(b);
        assertEquals(7, pinky.getCenterX());

        pinky.setRotate(180);
        pinky.afarm(b);
        assertEquals(6, pinky.getCenterX());
    }
}

