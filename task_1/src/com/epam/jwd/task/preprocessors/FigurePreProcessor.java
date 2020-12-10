package com.epam.jwd.task.preprocessors;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;

import java.util.List;

public interface FigurePreProcessor {
    void preProcess(List<Point> points) throws FigureException;
}
