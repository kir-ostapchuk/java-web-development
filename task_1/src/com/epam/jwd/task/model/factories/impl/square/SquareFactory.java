package com.epam.jwd.task.model.factories.impl.square;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.impl.line.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public enum SquareFactory implements FigureFactory<Square> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);

    @Override
    public Square createFigure(List<Point> points) {
        LOGGER.info("Square: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + ", " +
                points.get(3).toString() + " was created");
        return checkPool(points);
    }

    private Square checkPool(List<Point> points) {
        Iterator<Square> iterator = Square.squaresPool.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPoint(0).equals(points.get(0)) &&
                    iterator.next().getPoint(1).equals(points.get(1)) &&
                    iterator.next().getPoint(2).equals(points.get(2)) &&
                    iterator.next().getPoint(3).equals(points.get(3))) {
                return iterator.next();
            }
        }
        return new Square(points);
    }
}
