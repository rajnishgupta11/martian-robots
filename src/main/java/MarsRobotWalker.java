
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import model.Robot;
import model.Planet;
import model.RobotPosition;
import model.Point;
import model.Orientation;


/**
 * The type Mars robot walker.
 */
public class MarsRobotWalker {

    /**
     * Read input and walk string.
     *
     * @param fileName the file name
     * @return the string
     * @throws IOException the io exception
     */
    public String readInputAndWalk(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader=null;
        try {
            //Read input file
            Path path = Paths.get(fileName);
            reader = Files.newBufferedReader(path);
            String firstLine = reader.readLine();
            //System.out.println(firstLine);

            //Initialize planet Mars
            Planet planet = initializeMars(firstLine);

            final Iterator<String> iterator = reader.lines().iterator();
            while(iterator.hasNext()) {
                String robotStartLocationLine = iterator.next();
                if(!robotStartLocationLine.isEmpty()) {
                    //Create and initialize robot
                    Robot robot = createAndInitializeRobot(robotStartLocationLine, planet);
                    //System.out.println("Hi! from robot starting:" + robot);

                    //Execute robot instructions
                    String robotInstructionLine = iterator.next();
                    //System.out.println("robotInstructionLine:" + robotInstructionLine);
                    String resultRobotResult = robot.executeInstructions(parseInstructions(robotInstructionLine));
                    builder.append(resultRobotResult).append("\r\n");
                }
            }
         }  finally {
            if(reader!=null) {
                reader.close();
            }
        }
        return builder.toString();
    }

    private Robot createAndInitializeRobot(String nonEmptyLineInput, Planet planet) {
        String[] inputArray = nonEmptyLineInput.trim().split(" ");
        Point startLocation = new Point(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
        RobotPosition startRobotPosition = new RobotPosition(startLocation, Orientation.valueOf(inputArray[2]));

        return new Robot(startRobotPosition, planet);
    }

    private Planet initializeMars(String input) {
        String[] inputArray = input.trim().split(" ");
        return new Planet(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
    }

    private char[] parseInstructions(String inputInstructions) {
        if(inputInstructions.length() >100) {
            throw new IllegalArgumentException("Robot instructions greater than 100");
        }
         return inputInstructions.toCharArray();
    }
}
