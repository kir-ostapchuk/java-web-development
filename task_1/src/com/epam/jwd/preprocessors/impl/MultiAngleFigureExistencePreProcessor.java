package com.epam.jwd.preprocessors.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.preprocessors.FigurePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiAngleFigureExistencePreProcessor implements FigurePreProcessor {

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);
        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("MultiAngleFigure with " + points.size() + " was NOT created");
        }
    }
}
