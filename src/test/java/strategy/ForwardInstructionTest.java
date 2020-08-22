package strategy;

import model.Planet;
import model.Point;
import model.Robot;
import model.Orientation;
import model.RobotPosition;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ForwardInstructionTest {

    private RobotInstruction robotInstruction;
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        Planet planet = new Planet(50,50);
        Point point = new Point(1, 1);
        RobotPosition currentRobotPosition = new RobotPosition(point, Orientation.E);
        robot  =  new Robot(currentRobotPosition, planet);
        robotInstruction = new ForwardRobotInstruction();
    }
    @Test
    public void executeForwardInstruction()  {
        RobotPosition newRobotPosition = robotInstruction.execute(robot);
        assertEquals("2 1 E", newRobotPosition.toString());
    }
}
