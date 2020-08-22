package model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlanetTest {

    @Test
    public void isWithinBorder() throws Exception {
        Planet planet = new Planet(50,50);
        assertTrue(planet.isWithinBorder(new Point(10,10)));
    }
}
