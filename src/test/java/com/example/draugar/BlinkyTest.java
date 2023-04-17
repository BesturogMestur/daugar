package com.example.draugar;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlinkyTest {
    private final double[] A = {0, 0};
    private final double[] B = {10, 10};
    private final double[] HOME = {6, 6};
    private final double[] HOME_BASE = {10, 0};
    private Blinky blinky;
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

        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        pacman.setCenterX(6);
        pacman.setCenterY(0);

        double[] a = {6, 5};
        assertEquals(25, (int) blinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(37, (int) blinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(49, (int) blinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(37, (int) blinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        pacman = new Pacman();

        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        blinky.setElta(false);

        double[] a = {6, 5};
        assertEquals(41, (int) blinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(61, (int) blinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(65, (int) blinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(45, (int) blinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten(){
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        blinky.setEtan(true);

        double[] a = {6, 5};
        assertEquals(1, (int) blinky.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(1, (int) blinky.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(1, (int) blinky.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(1, (int) blinky.drauaReikniritd(d));
    }

    @Test
    public void testAfram(){
        pacman = new Pacman();
        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE);
        pacman.setCenterX(6);
        pacman.setCenterY(0);
        blinky.setCenterX(6);
        blinky.setCenterY(6);

        boolean[] b = {false,true,false,true};
        blinky.afarm(b);

        assertEquals(7, blinky.getCenterX());
        blinky.setRotate(180);
        blinky.afarm(b);

        assertEquals(6, blinky.getCenterX());
    }
}
