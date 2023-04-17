package com.example.draugar;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InkyTest {
    private final double[] A = {0, 0};
    private final double[] B = {10, 10};
    private final double[] HOME = {6, 6};
    private final double[] HOME_BASE = {10, 10};
    private final double[] HOME_BASE_BLINKY = {10, 0};
    private Blinky blinky;
    private Inky inky;
    private Pacman pacman;

    @Before
    public void carateParameters() {
        //pacman = new Pacman();
        //pacman.setCenterX(6);
        //pacman.setCenterY(0);

        // blinky = new Blinky(true,pacman, A, B,HOME, HOME_BASE);
        //blinky.setCenterX(6);
        //blinky.setCenterY(6);
    }

    @Test
    public void testDrugaRikniritElta() {
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE_BLINKY);
        inky = new Inky(true, pacman, A, B, HOME, HOME_BASE, blinky);


        pacman.setCenterX(6);
        pacman.setCenterY(6);
        blinky.setCenterX(7);
        blinky.setCenterY(9);

        double[] a = {8, 7};
        assertEquals(5, (int) blinky.drauaReikniritd(a));

        double[] b = {7, 8};
        assertEquals(5, (int) blinky.drauaReikniritd(b));

        double[] c = {8, 9};
        assertEquals(13, (int) blinky.drauaReikniritd(c));

        double[] d = {9, 8};
        assertEquals(13, (int) blinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE_BLINKY);
        inky = new Inky(true, pacman, A, B, HOME, HOME_BASE, blinky);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        inky.setElta(false);

        double[] a = {6, 5};
        assertEquals(41, (int) inky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(41, (int) inky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(25, (int) inky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(25, (int) inky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten() {
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        inky = new Inky(true, pacman, A, B, HOME, HOME_BASE, blinky);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        inky.setEtan(true);

        double[] a = {6, 5};
        assertEquals(1, (int) inky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(1, (int) inky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(1, (int) inky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(1, (int) inky.drauaReikniritd(d));
    }

    @Test
    public void testAfram() {
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        inky = new Inky(true, pacman, A, B, HOME, HOME_BASE, blinky);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        blinky.setCenterX(7);
        blinky.setCenterY(6);
        inky.setCenterX(8);
        inky.setCenterY(8);

        boolean[] b = {false, true, false, true};
        inky.setRotate(90);
        inky.afarm(b);
        assertEquals(7, inky.getCenterX());
        inky.setRotate(90);
        inky.afarm(b);

        assertEquals(6, inky.getCenterX());
    }
}

