package com.epam.jwd.service.impl.preprocessor;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.triangle.TriangleFactory;
import com.epam.jwd.service.FigurePreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleExistencePreProcessor implements FigurePreProcessor {

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public boolean process(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        if (compressPoints.size() == points.size()) {
            int answer =
                    points.get(0).getX() * (points.get(1).getY() - points.get(2).getY()) +
                            points.get(1).getX() * (points.get(1).getY() - points.get(2).getY()) +
                            points.get(1).getX() * (points.get(1).getY() - points.get(2).getY());
            return answer != 0;
        } else {
            return false;
        }
    }
}
