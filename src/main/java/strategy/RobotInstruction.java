package strategy;

import model.Robot;
import model.RobotPosition;

/**
 * The interface Robot instruction.
 */
public interface RobotInstruction {

    RobotPosition execute(Robot robot);
}
