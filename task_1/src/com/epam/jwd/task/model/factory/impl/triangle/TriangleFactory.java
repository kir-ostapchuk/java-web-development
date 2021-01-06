package com.epam.jwd.task.model.factory.impl.triangle;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.storage.TriangleStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum TriangleFactory implements FigureFactory<Triangle> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public Triangle createFigure(List<Point> points, String name, Color color) {
        Triangle triangle = new Triangle(points, name, color);
        TriangleStorage.triangleStorage.add(triangle);
        LOGGER.info(triangle.toString() + " was created");
        return triangle;
    }
}
