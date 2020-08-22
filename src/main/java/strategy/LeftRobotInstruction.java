package strategy;

import model.Orientation;
import model.Robot;
import model.RobotPosition;

/**
 * The type Left robot instruction.
 */
public class LeftRobotInstruction implements RobotInstruction {

    public RobotPosition execute(Robot robot) {
        RobotPosition currentRobotPosition = robot.getRobotPosition();
        RobotPosition newRobotPosition=null;
        switch (currentRobotPosition.getOrientation()) {
            case N:
                newRobotPosition = new RobotPosition(currentRobotPosition.getLocation(), Orientation.W);
                break;
            case W:
                newRobotPosition = new RobotPosition(currentRobotPosition.getLocation(), Orientation.S);
                break;
            case S:
                newRobotPosition = new RobotPosition(currentRobotPosition.getLocation(), Orientation.E);
                break;
            case E:
                newRobotPosition = new RobotPosition(currentRobotPosition.getLocation(), Orientation.N);
                break;
        }
        return newRobotPosition;
    }
}
