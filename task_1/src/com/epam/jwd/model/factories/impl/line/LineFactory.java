package com.epam.jwd.model.factories.impl.line;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum LineFactory implements FigureFactory<Line> {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points) {
        LOGGER.info("Line: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + " was created");
        return new Line(points);
    }
}
