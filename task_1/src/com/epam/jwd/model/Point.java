package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point {

    private static final Logger LOGGER = LogManager.getLogger(Point.class);

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        LOGGER.info("Point: x=" + x + ", y=" + y + " was created");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public static int squareDis(Point p1, Point p2)
    {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

}
