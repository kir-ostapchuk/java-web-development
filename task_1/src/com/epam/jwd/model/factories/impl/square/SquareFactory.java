package com.epam.jwd.model.factories.impl.square;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        return new Square(points);
    }
}
