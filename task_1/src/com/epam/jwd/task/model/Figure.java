package com.epam.jwd.task.model;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class Figure {

    private final List<Point> points;
    private final String name;
    private final UUID id;
    private final Color color;

    public Figure(List<Point> points, String name, Color color) {
        this.points = points;
        this.name = name;
        this.color = color;
        id = UUID.randomUUID();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public UUID getId() {
        return id;
    }
}
