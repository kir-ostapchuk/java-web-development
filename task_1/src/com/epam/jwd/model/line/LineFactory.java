package com.epam.jwd.model.line;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineFactory implements FigureFactory<Line> {

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points) throws FigureNotExistException{
        boolean isCreatable = canCreateLine(points);
//        checkCreatability(isCreatable);
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

    private boolean canCreateLine(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        return compressPoints.size() == points.size();
    }
}
