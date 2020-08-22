package model;

import java.util.HashSet;
import java.util.Set;

public class Planet {

    private final int xBound;
    private final int yBound;
    private Set<Point> scentsSet;

    public Planet(int xBound, int yBound) {
        this.xBound = xBound;
        this.yBound = yBound;
        scentsSet = new HashSet<>();
    }


    public boolean isWithinBorder(Point point) {
        return (point.getX() >= 0 && point.getX() <= xBound && point.getY() >= 0 && point.getY() <= yBound);
    }

    public boolean isScented(Point point) {
        return scentsSet.contains(point);
    }

    public void addScent(Point point) {
        scentsSet.add(point);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "xBound=" + xBound +
                ", yBound=" + yBound +
                ", scentsSet=" + scentsSet +
                '}';
    }
}
