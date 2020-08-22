import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static junit.framework.TestCase.assertEquals;

public class MarsRobotWalkerTest {

    private MarsRobotWalker marsRobotWalker;

    @Before
    public void setUp() throws Exception {
        marsRobotWalker = null;
    }
    @Test(expected = IOException.class)
    public void nonexistentInputFile() throws IOException {
        marsRobotWalker = new MarsRobotWalker();
        marsRobotWalker.readInputAndWalk("src/test/resources/abc.txt");
    }

    @Test
    public void marsRobotWalkerMovements() throws Exception {
        marsRobotWalker = new MarsRobotWalker();
        String outputString = marsRobotWalker.readInputAndWalk("src/test/resources/robotMovements.txt");
        System.out.println(outputString);
        assertEquals("1 1 E"       + "\r\n"
                            + "3 3 N LOST" + "\r\n"
                            + "2 3 S"      + "\r\n",
                     outputString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void robotInstructionCharacterLengthOutofBounds() throws Exception {
        marsRobotWalker = new MarsRobotWalker();
        marsRobotWalker.readInputAndWalk("src/test/resources/robotMovementsInstructionLengthGreaterThan100.txt");
    }

}
