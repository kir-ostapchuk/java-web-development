package com.epam.jwd.service.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureBeforeProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineExistenceBeforeProcessor implements FigureBeforeProcessor {

    @Override
    public boolean process(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        return compressPoints.size() == points.size();
    }
}
