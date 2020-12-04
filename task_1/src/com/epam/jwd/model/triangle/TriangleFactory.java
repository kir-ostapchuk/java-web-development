package com.epam.jwd.model.triangle;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.TriangleExistencePreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum TriangleFactory implements FigureFactory<Triangle> {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public Triangle createFigure(List<Point> points) throws FigureNotExistException {
        TriangleExistencePreProcessor processor = new TriangleExistencePreProcessor();
        boolean isCreatable = processor.process(points);
        if (!isCreatable) {
            throw new FigureNotExistException("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created");
        }
        LOGGER.info("Triangle: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + " was created");
        return new Triangle(points);
    }
}
