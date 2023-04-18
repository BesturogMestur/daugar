package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaydeTest {
    private final int[] A = {0, 0};
    private final int[] B = {10, 10};
    private final int[] HOME = {6, 6};
    private final int[] HOME_BASE = {0, 10};
    private Clyde clyde;
    private Pacman pacman;

    @Before
    public void carateParameters() {
        pacman = new Pacman();
        pacman.setCenterX(10);
        pacman.setCenterY(10);
        clyde = new Clyde(true, pacman, A, B, HOME, HOME_BASE);
        clyde.setCenterX(2);
        clyde.setCenterY(6);
    }

    @Test
    public void testDrugaRikniritEltaUndanRadius() {
        int[] a = {2, 5};
        assertEquals(89, clyde.drauaReikniritd(a));

        int[] b = {1, 6};
        assertEquals(97, (int) clyde.drauaReikniritd(b));

        int[] c = {2, 7};
        assertEquals(73, (int) clyde.drauaReikniritd(c));

        int[] d = {3, 6};
        assertEquals(65, (int) clyde.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEltaInnanRadius() {
        clyde.setCenterX(8);
        clyde.setCenterY(8);

        int[] a = {8, 7};
        assertEquals(73,  clyde.drauaReikniritd(a));

        int[] b = {7, 8};
        assertEquals(53,  clyde.drauaReikniritd(b));

        int[] c = {8, 9};
        assertEquals(65,  clyde.drauaReikniritd(c));

        int[] d = {9, 8};
        assertEquals(85,  clyde.drauaReikniritd(d));
    }


    @Test
    public void testDrugaRikniritNotEltaUndanRadius() {
        clyde.setElta(false);

        int[] a = {2, 5};
        assertEquals(29,  clyde.drauaReikniritd(a));

        int[] b = {1, 6};
        assertEquals(17,  clyde.drauaReikniritd(b));

        int[] c = {2, 7};
        assertEquals(13,  clyde.drauaReikniritd(c));

        int[] d = {3, 6};
        assertEquals(25,  clyde.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten() {
        clyde.setEtan(true);

        int[] a = {6, 5};
        assertEquals(1,  clyde.drauaReikniritd(a));

        int[] b = {5, 6};
        assertEquals(1,  clyde.drauaReikniritd(b));

        int[] c = {6, 7};
        assertEquals(1,  clyde.drauaReikniritd(c));

        int[] d = {7, 6};
        assertEquals(1,  clyde.drauaReikniritd(d));
    }

    @Test
    public void testAfram() {
        boolean[] b = {false, true, false, true};
        clyde.setRotate(90);

        clyde.afarm(b);
        assertEquals(3, clyde.getCenterX());
        clyde.setRotate(90);
        clyde.afarm(b);

        assertEquals(4, clyde.getCenterX());
    }
}
