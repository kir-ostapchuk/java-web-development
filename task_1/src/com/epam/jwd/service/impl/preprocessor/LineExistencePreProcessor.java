package com.epam.jwd.service.impl.preprocessor;

import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineExistencePreProcessor implements FigurePreProcessor {

    @Override
    public boolean process(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        return compressPoints.size() == points.size();
    }
}
