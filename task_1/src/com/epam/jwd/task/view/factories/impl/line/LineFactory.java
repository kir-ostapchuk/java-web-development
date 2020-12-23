package com.epam.jwd.task.view.factories.impl.line;

import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.view.Color;
import com.epam.jwd.task.model.LineStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum LineFactory implements FigureFactory<Line> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points, String name, Color color) {
        Line line = new Line(points, name, color);
        LineStorage.lineStorage.add(line);
        LOGGER.info(line.toString() + " was created");
        return line;
    }
}
