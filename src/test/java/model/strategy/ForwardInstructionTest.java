package model.strategy;

import model.*;
import org.junit.Before;
import org.junit.Test;
import strategy.LeftRobotInstruction;
import strategy.RightRobotInstruction;
import strategy.RobotInstruction;

import static junit.framework.TestCase.assertEquals;

public class RightInstructionTest {

    private RobotInstruction robotInstruction;
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        Planet planet = new Planet(50,50);
        Point point = new Point(1, 1);
        RobotPosition currentRobotPosition = new RobotPosition(point, Orientation.E);
        robot  =  new Robot(currentRobotPosition, planet);
        robotInstruction = new RightRobotInstruction();
    }
    @Test
    public void executeRightInstruction()  {
        RobotPosition newRobotPosition = robotInstruction.execute(robot);
        assertEquals("1 1 S", newRobotPosition.toString());
    }
}
