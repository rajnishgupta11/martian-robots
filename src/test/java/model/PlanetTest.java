package model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlanetTest {

    @Test
    public void testPlanetBoundariesWithinBorder()  {
        Planet planet = new Planet(50,50);
        assertTrue(planet.isWithinBorder(new Point(10,10)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlanetBoundariesOutsideBorder()  {
        Planet planet = new Planet(51,51);
        assertTrue(planet.isWithinBorder(new Point(10,10)));
    }
}
