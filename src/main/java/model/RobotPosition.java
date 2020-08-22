package model;

/**
 * The type Robot position.
 */
public class RobotPosition {

    private Point location;
    private Orientation orientation;

    public RobotPosition(Point location, Orientation orientation) {
        this.location = location;
        this.orientation = orientation;
    }

    public Point getLocation() {
        return location;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return location + " " + orientation;
    }
}
