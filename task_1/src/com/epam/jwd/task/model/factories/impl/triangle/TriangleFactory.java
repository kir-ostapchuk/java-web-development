package com.epam.jwd.task.model.factories.impl.triangle;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum TriangleFactory implements FigureFactory<Triangle> {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public Triangle createFigure(List<Point> points) {
        LOGGER.info("Triangle: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + " was created");
        return new Triangle(points);
    }
}
