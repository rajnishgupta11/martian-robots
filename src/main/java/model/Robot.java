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

    public Planet getPlanet() {
        return planet;
    }

    public RobotPosition getRobotPosition() {
        return robotPosition;
    }

    public void setRobotPosition(RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    /**
     * Execute instructions string.
     *
     * @param instructions the instructions
     * @return the string
     */
    public String executeInstructions(char[] instructions) {
        for (char currentInstruction : instructions) {
            if (!lost) {
                RobotInstruction robotInstructionStrategy = charToStrategyMap.get(currentInstruction);
                robotInstructionStrategy.execute(this);
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
