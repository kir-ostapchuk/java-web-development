package com.epam.jwd.task.view;

import java.util.List;
import java.util.UUID;

public abstract class Figure {

    private final String name;
    private final UUID id;
    private final Color color;

    public Figure(String name, Color color) {
        this.name = name;
        this.color = color;
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public abstract List<Point> getPoints();
}
