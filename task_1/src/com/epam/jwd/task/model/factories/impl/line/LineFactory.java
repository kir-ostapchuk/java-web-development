package com.epam.jwd.task.model.factories.impl.line;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum LineFactory implements FigureFactory<Line> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points, String name, Color color) {
        Line line = new Line(points, name, color);
//        LineStorage.linesStorage.add(line);
        LOGGER.info(line.toString() + " was created");
        return line;
    }
}
