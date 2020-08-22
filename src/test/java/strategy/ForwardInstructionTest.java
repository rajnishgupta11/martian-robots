package model.strategy;

import model.*;
import org.junit.Before;
import org.junit.Test;
import strategy.ForwardRobotInstruction;
import strategy.RightRobotInstruction;
import strategy.RobotInstruction;

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
