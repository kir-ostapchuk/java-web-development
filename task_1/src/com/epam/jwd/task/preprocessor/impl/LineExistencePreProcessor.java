package com.epam.jwd.task.preprocessor.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.preprocessor.ExistencePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineExistencePreProcessor implements ExistencePreProcessor {

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);
        if (points.size() < 2) {
            throw new FigureNotExistException("Line was NOT created. There are only " + points.size() + " points");
        }
        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("Line: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + " was NOT created. There are equal points");
        }
    }
}
