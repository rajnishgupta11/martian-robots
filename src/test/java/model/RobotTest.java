package model;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class RobotTest {

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        Planet planet = new Planet(50,50);
        Point point = new Point(1, 1);
        RobotPosition currentRobotPosition = new RobotPosition(point, Orientation.E);
        robot  =  new Robot(currentRobotPosition, planet);
    }

    @Test
    public void testRobotExecuteInstructionsWithoutGettingLost()  {
        String robotInstructons1 = "RFRFRFRF";
        String result = robot.executeInstructions(robotInstructons1.toCharArray());
        assertEquals("1 1 E", result);
    }

    @Test
    public void testRobotExecuteInstructionsGettingLost()  {
        String robotInstructons2 = "FRRFLLFFRRFLL";
        String result = robot.executeInstructions(robotInstructons2.toCharArray());
        assertEquals("3 3 N LOST", result);
    }

}
