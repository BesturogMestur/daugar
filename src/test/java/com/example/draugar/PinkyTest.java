package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PinkyTest {
    private final int[] A = {0, 0};
    private final int[] B = {10, 10};
    private final int[] HOME = {6, 6};
    private final int[] HOME_BASE = {0, 0};
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
        int[] a = {6, 5};
        assertEquals(41,  pinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(61,  pinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(65,  pinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(45,  pinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritNotElta() {
        pinky.setElta(false);

        int[] a = {6, 5};
        assertEquals(61,  pinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(61,  pinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(85,  pinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(85,  pinky.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten(){
        pinky.setEtan(true);

        int[] a = {6, 5};
        assertEquals(1,  pinky.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(1,  pinky.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(1,  pinky.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(1,  pinky.drauaReikniritd(d));
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

