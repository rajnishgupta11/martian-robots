import model.Point;
import model.Robot;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MarsRobotWalkerTest {

    @Test
    public void testMarsBoundaryLimits() throws Exception {
        Assert.fail("Not yet implemented");
    }

    @Test
    public void testRobotInstructionCharacterLength() throws Exception {
        Assert.fail("Not yet implemented");
    }

    /*@Test(expected = IOException.class)
    public void testMarsRobotWalkerMovementsWithInputFileNotContainingCommandsNotFound() throws IOException {
        MarsRobotWalker marsRobotWalker = new MarsRobotWalker();
        marsRobotWalker.readInputAndWalk("src/test/resources/abc.txt");
    }*/

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
}
