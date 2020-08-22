package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlanetTest {

    private Planet planet;

    @Before
    public void setUp() throws Exception {
        planet = null;
    }
    @Test
    public void planetBoundariesWithinBorder()  {
        planet = new Planet(50,50);
        assertTrue(planet.isWithinBorder(new Point(10,10)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void planetBoundariesOutsideBorder()  {
        planet = new Planet(51,51);
        assertTrue(planet.isWithinBorder(new Point(10,10)));
    }
}
