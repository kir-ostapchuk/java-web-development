package com.epam.jwd.task.model.factory.impl.square;

import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.storage.SquareStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum SquareFactory implements FigureFactory<Square> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);

    @Override
    public Square createFigure(List<Point> points, String name, Color color) {
        Square square = new Square(points, name, color);
        SquareStorage.squareStorage.add(square);
        LOGGER.info(square.toString() + " was created");
        return square;
    }
}
