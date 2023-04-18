package com.example.draugar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaydeTest {
    private final double[] A = {0, 0};
    private final double[] B = {10, 10};
    private final double[] HOME = {6, 6};
    private final double[] HOME_BASE = {0, 10};
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
        double[] a = {2, 5};
        assertEquals(89, (int) clyde.drauaReikniritd(a));

        double[] b = {1, 6};
        assertEquals(97, (int) clyde.drauaReikniritd(b));

        double[] c = {2, 7};
        assertEquals(73, (int) clyde.drauaReikniritd(c));

        double[] d = {3, 6};
        assertEquals(65, (int) clyde.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEltaInnanRadius() {
        clyde.setCenterX(8);
        clyde.setCenterY(8);

        double[] a = {8, 7};
        assertEquals(73, (int) clyde.drauaReikniritd(a));

        double[] b = {7, 8};
        assertEquals(53, (int) clyde.drauaReikniritd(b));

        double[] c = {8, 9};
        assertEquals(65, (int) clyde.drauaReikniritd(c));

        double[] d = {9, 8};
        assertEquals(85, (int) clyde.drauaReikniritd(d));
    }


    @Test
    public void testDrugaRikniritNotEltaUndanRadius() {
        clyde.setElta(false);

        double[] a = {2, 5};
        assertEquals(29, (int) clyde.drauaReikniritd(a));

        double[] b = {1, 6};
        assertEquals(17, (int) clyde.drauaReikniritd(b));

        double[] c = {2, 7};
        assertEquals(13, (int) clyde.drauaReikniritd(c));

        double[] d = {3, 6};
        assertEquals(25, (int) clyde.drauaReikniritd(d));
    }

    @Test
    public void testDrugaRikniritEaten() {
        clyde.setEtan(true);

        double[] a = {6, 5};
        assertEquals(1, (int) clyde.drauaReikniritd(a));

        double[] b = {5, 6};
        assertEquals(1, (int) clyde.drauaReikniritd(b));

        double[] c = {6, 7};
        assertEquals(1, (int) clyde.drauaReikniritd(c));

        double[] d = {7, 6};
        assertEquals(1, (int) clyde.drauaReikniritd(d));
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
