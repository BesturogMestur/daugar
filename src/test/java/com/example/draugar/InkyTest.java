package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InkyTest {
    private final int[] A = {0, 0};
    private final int[] B = {10, 10};
    private final int[] HOME = {6, 6};
    private final int[] HOME_BASE = {10, 10};
    private final int[] HOME_BASE_BLINKY = {10, 0};
    private Blinky blinky;
    private Inky inky;
    private Pacman pacman;

    @Before
    public void carateParameters() {
        pacman = new Pacman();
        pacman.setCenterX(6);
        pacman.setCenterY(6);

        blinky = new Blinky(true, pacman, A, B, HOME, HOME_BASE_BLINKY);
        blinky.setCenterX(7);
        blinky.setCenterY(6);

        inky = new Inky(true, pacman, A, B, HOME, HOME_BASE, blinky);
        inky.setCenterX(8);
        inky.setCenterY(8);
    }

    @Test
    public void testDrugaRikniritElta() {

        int[] a = {8, 7};
        assertEquals(2,  inky.drauaReikniritd(a));

        int[] b = {7, 8};
        assertEquals(4,  inky.drauaReikniritd(b));

        int[] c = {8, 9};
        assertEquals(10,  inky.drauaReikniritd(c));

        int[] d = {9, 8};
        assertEquals(8,  inky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        inky.setElta(false);

        int[] a = {8, 7};
        assertEquals(13,  inky.drauaReikniritd(a));

        int[] b = {7, 8};
        assertEquals(13,  inky.drauaReikniritd(b));

        int[] c = {8, 9};
        assertEquals(5,  inky.drauaReikniritd(c));

        int[] d = {9, 8};
        assertEquals(5,  inky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten() {
        inky.setEtan(true);

        int[] a = {6, 5};
        assertEquals(1,  inky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(1,  inky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(1,  inky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(1,  inky.drauaReikniritd(d));
    }

    @Test
    public void testAfram() {

        boolean[] b = {false, true, false, true};
        inky.setRotate(90);
        inky.afarm(b);
        assertEquals(7, inky.getCenterX());
        inky.setRotate(90);
        inky.afarm(b);

        assertEquals(6, inky.getCenterX());
    }
}

