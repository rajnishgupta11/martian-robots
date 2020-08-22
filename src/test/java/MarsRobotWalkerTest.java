import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class MarsRobotWalkerTest {

    @Test(expected = IOException.class)
    public void testMarsRobotWalkerMovementsWithInputFileNotContainingCommandsNotFound() throws IOException {
        MarsRobotWalker marsRobotWalker = new MarsRobotWalker();
        marsRobotWalker.readInputAndWalk("src/test/resources/abc.txt");
    }

    @Test
    public void testMarsRobotWalkerMovements() throws Exception {
        MarsRobotWalker marsRobotWalker = new MarsRobotWalker();
        String outputString = marsRobotWalker.readInputAndWalk("src/test/resources/robotMovements.txt");
        System.out.println(outputString);
        assertEquals("1 1 E"       + "\r\n"
                            + "3 3 N LOST" + "\r\n"
                            + "2 3 S"      + "\r\n",
                     outputString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRobotInstructionCharacterLengthOutofBounds() throws Exception {
        MarsRobotWalker marsRobotWalker = new MarsRobotWalker();
        marsRobotWalker.readInputAndWalk("src/test/resources/robotMovementsInstructionLengthGreaterThan100.txt");
    }

}
