package strategy;

import model.Robot;
import model.RobotPosition;

public interface RobotInstruction {

    RobotPosition execute(Robot robot);
}
