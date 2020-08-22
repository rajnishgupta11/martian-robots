package model.strategy;

import model.*;
import org.junit.Before;
import org.junit.Test;
import strategy.LeftRobotInstruction;
import strategy.RobotInstruction;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeftInstructionTest {

    private RobotInstruction robotInstruction;
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        Planet planet = new Planet(50,50);
        Point point = new Point(1, 1);
        RobotPosition currentRobotPosition = new RobotPosition(point, Orientation.E);
        robot  =  new Robot(currentRobotPosition, planet);
        robotInstruction = new LeftRobotInstruction();
    }
    @Test
    public void executeLeftInstruction()  {
        RobotPosition newRobotPosition = robotInstruction.execute(robot);
        System.out.println(newRobotPosition);
        assertEquals("1 1 N", newRobotPosition.toString());
    }
}
