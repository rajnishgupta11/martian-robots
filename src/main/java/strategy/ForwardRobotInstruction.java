package strategy;

import model.Point;
import model.Robot;
import model.RobotPosition;

/**
 * The type Forward robot instruction.
 */
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
        //Check newRobotPosition is within Mars boundaries
        if (robot.getPlanet().isWithinBorder(newRobotPosition.getLocation())) {
            robot.setRobotPosition(newRobotPosition);
            //if robot is outside bounds, add item to scentSet and mark robot as lost
        } else if (!robot.getPlanet().isScented(robot.getRobotPosition().getLocation())) {
            robot.getPlanet().addScent(robot.getRobotPosition().getLocation());
            robot.setLost(true);
        }
        return newRobotPosition;
    }
}
