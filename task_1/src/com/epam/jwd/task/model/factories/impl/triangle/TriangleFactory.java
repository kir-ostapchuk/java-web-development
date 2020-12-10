package com.epam.jwd.task.model.factories.impl.triangle;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.impl.square.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
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
        return checkPool(points);
    }

    private Triangle checkPool(List<Point> points) {
        Iterator<Triangle> iterator = Triangle.trianglesPool.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPoint(0).equals(points.get(0)) &&
                    iterator.next().getPoint(1).equals(points.get(1)) &&
                    iterator.next().getPoint(2).equals(points.get(2))) {
                return iterator.next();
            }
        }
        return new Triangle(points);
    }
}
