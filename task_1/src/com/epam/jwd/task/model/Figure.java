package com.epam.jwd.task.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(points, figure.points) &&
                Objects.equals(name, figure.name) &&
                Objects.equals(id, figure.id) &&
                color == figure.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, name, id, color);
    }
}
