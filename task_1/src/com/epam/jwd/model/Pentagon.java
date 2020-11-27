package com.epam.jwd.model;

import java.util.List;

public class Pentagon {
    private List<Point> points;

    Pentagon(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSides() {
        return points.size();
    }
}
