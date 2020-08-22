package model;

import strategy.ForwardRobotInstruction;
import strategy.LeftRobotInstruction;
import strategy.RightRobotInstruction;
import strategy.RobotInstruction;


public class Robot {

    private RobotPosition robotPosition;
    private Planet planet;
    private boolean lost = false;

    public Robot(RobotPosition robotPosition, Planet planet) {
        this.robotPosition = robotPosition;
        this.planet = planet;
    }

    public RobotPosition getRobotPosition() {
        return robotPosition;
    }

    public void executeInstructions(char[] instructions) {
        RobotInstruction robotInstructionStrategy = null;
        RobotPosition newRobotPosition = null;
        for (char currentInstruction : instructions) {
            if (!lost) {
                switch (currentInstruction) {
                    case 'L':
                        robotInstructionStrategy = new LeftRobotInstruction();
                        newRobotPosition = robotInstructionStrategy.execute(this);
                        this.robotPosition = newRobotPosition;
                        break;
                    case 'R':
                        robotInstructionStrategy = new RightRobotInstruction();
                        newRobotPosition = robotInstructionStrategy.execute(this);
                        this.robotPosition = newRobotPosition;
                        break;
                    case 'F':
                        robotInstructionStrategy = new ForwardRobotInstruction();
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

                System.out.println("Instruction:" + currentInstruction + " newRobotPosition:" + this.robotPosition.getLocation().toString() + " " + this.robotPosition.getOrientation().name());
            }
        }
    }

    @Override
    public String toString() {
        return robotPosition.getLocation().toString() + " " + robotPosition.getOrientation().name() +  (lost ? " LOST" : "");
    }

}
