package com.epam.jwd.task.model.factories.impl.line;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public enum LineFactory implements FigureFactory<Line> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points) {
        LOGGER.info("Line: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + " was created");
        return checkPool(points);
    }

    private Line checkPool(List<Point> points) {
        Iterator<Line> iterator = Line.linesPool.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPoint(0).equals(points.get(0)) &&
                    iterator.next().getPoint(1).equals(points.get(1))) {
                return iterator.next();
            }
        }
        return new Line(points);
    }
}
