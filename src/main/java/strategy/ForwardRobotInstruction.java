package strategy;

import model.Point;
import model.Robot;
import model.RobotPosition;

public class ForwardRobotInstruction implements RobotInstruction {

    public RobotPosition execute(Robot robot) {
        RobotPosition currentRobotPosition = robot.getRobotPosition();
        RobotPosition newRobotPosition = null;
        Point newLocation;
        switch (currentRobotPosition.getOrientation()) {
            case N:
                newLocation = new Point(currentRobotPosition.getLocation().getX() , currentRobotPosition.getLocation().getY() + 1);
                newRobotPosition = new RobotPosition(newLocation, currentRobotPosition.getOrientation());
                break;
            case W:
                newLocation = new Point(currentRobotPosition.getLocation().getX() - 1, currentRobotPosition.getLocation().getY());
                newRobotPosition = new RobotPosition(newLocation, currentRobotPosition.getOrientation());
                break;
            case S:
                newLocation = new Point(currentRobotPosition.getLocation().getX(), currentRobotPosition.getLocation().getY() - 1);
                newRobotPosition = new RobotPosition(newLocation, currentRobotPosition.getOrientation());
                break;
            case E:
                newLocation = new Point(currentRobotPosition.getLocation().getX() + 1, currentRobotPosition.getLocation().getY());
                newRobotPosition = new RobotPosition(newLocation, currentRobotPosition.getOrientation());
                break;
        }
        return newRobotPosition;
    }
}
