package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlinkyTest {
    private final int[] A = {0, 0};
    private final int[] B = {10, 10};
    private final int[] HOME = {6, 6};
    private final int[] HOME_BASE = {10, 0};
    private Blinky blinky;
    private Pacman pacman;

    @Before
    public void carateParameters() {
        pacman = new Pacman();
        pacman.setCenterX(6);
        pacman.setCenterY(0);

        blinky = new Blinky(true,pacman, A, B,HOME, HOME_BASE);
        blinky.setCenterX(6);
        blinky.setCenterY(6);
    }

    @Test
    public void testDrugaRikniritElta() {
        int[] a = {6, 5};
        assertEquals(25,  blinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(37,  blinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(49, blinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(37,  blinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        blinky.setElta(false);

        int[] a = {6, 5};
        assertEquals(41,  blinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(61,  blinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(65,  blinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(45,  blinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten(){
        blinky.setEtan(true);

        int[] a = {6, 5};
        assertEquals(1,  blinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(1,  blinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(1,  blinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(1,  blinky.drauaReikniritd(d));
    }

    @Test
    public void testAfram(){
        boolean[] b = {false,true,false,true};
        blinky.afarm(b);

        assertEquals(7, blinky.getCenterX());
        blinky.setRotate(180);
        blinky.afarm(b);

        assertEquals(6, blinky.getCenterX());
    }
}
