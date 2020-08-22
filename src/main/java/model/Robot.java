package model;

import strategy.ForwardRobotInstruction;
import strategy.LeftRobotInstruction;
import strategy.RightRobotInstruction;
import strategy.RobotInstruction;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Robot.
 */
public class Robot {

    private RobotPosition robotPosition;
    private Planet planet;
    private boolean lost = false;
    private Map<Character, RobotInstruction> charToStrategyMap;

    /**
     * Instantiates a new Robot.
     *
     * @param robotPosition the robot position
     * @param planet        the planet
     */
    public Robot(RobotPosition robotPosition, Planet planet) {
        this.robotPosition = robotPosition;
        this.planet = planet;
        charToStrategyMap = new HashMap<>();
        charToStrategyMap.put('L',  new LeftRobotInstruction());
        charToStrategyMap.put('R',  new RightRobotInstruction());
        charToStrategyMap.put('F',  new ForwardRobotInstruction());
    }

    /**
     * Gets robot position.
     *
     * @return the robot position
     */
    public RobotPosition getRobotPosition() {
        return robotPosition;
    }

    /**
     * Execute instructions string.
     *
     * @param instructions the instructions
     * @return the string
     */
    public String executeInstructions(char[] instructions) {
        RobotInstruction robotInstructionStrategy = null;
        RobotPosition newRobotPosition = null;
        for (char currentInstruction : instructions) {
            if (!lost) {
                switch (currentInstruction) {
                    case 'L':
                    case 'R':
                        robotInstructionStrategy = charToStrategyMap.get(currentInstruction);
                        newRobotPosition = robotInstructionStrategy.execute(this);
                        this.robotPosition = newRobotPosition;
                        break;
                    case 'F':
                        robotInstructionStrategy = charToStrategyMap.get('F');
                        newRobotPosition = robotInstructionStrategy.execute(this);

                        //Check newRobotPosition is within Mars boundaries
                        if (planet.isWithinBorder(newRobotPosition.getLocation())) {
                            this.robotPosition = newRobotPosition;
                         //if robot is outside bounds, add item to scentSet and mark robot as lost
                        } else if (!planet.isScented(this.robotPosition.getLocation())) {
                            planet.addScent(robotPosition.getLocation());
                            lost = true;
                        }
                        break;
                }
                //System.out.println("Instruction:" + currentInstruction + " newRobotPosition:" + this.robotPosition.getLocation().toString() + " " + this.robotPosition.getOrientation().name());
            }
        }
        return  toString();
    }

    @Override
    public String toString() {
        return robotPosition.getLocation().toString() + " " + robotPosition.getOrientation().name() +  (lost ? " LOST" : "");
    }

}
