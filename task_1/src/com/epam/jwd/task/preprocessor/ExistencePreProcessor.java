package com.epam.jwd.task.preprocessor;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;

import java.util.List;

@FunctionalInterface
public interface ExistencePreProcessor {

    void preProcess(List<Point> points) throws FigureException;
}
