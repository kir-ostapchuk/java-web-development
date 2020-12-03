package com.epam.jwd.model.line;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.LineExistenceBeforeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum LineFactory implements FigureFactory<Line> {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points) throws FigureNotExistException{
        LineExistenceBeforeProcessor processor = new LineExistenceBeforeProcessor();
        boolean isCreatable = processor.process(points);
        if (!isCreatable) {
            throw new FigureNotExistException("Line: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + " was NOT created");
        }
        LOGGER.info("Line: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + " was created");
        return new Line(points);
    }
}
