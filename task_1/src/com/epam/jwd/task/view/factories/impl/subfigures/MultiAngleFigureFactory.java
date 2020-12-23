package com.epam.jwd.task.view.factories.impl.subfigures;

import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.view.Color;
import com.epam.jwd.task.model.MultiAngleFigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum MultiAngleFigureFactory implements FigureFactory<MultiAngleFigure> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigureFactory.class);

    @Override
    public MultiAngleFigure createFigure(List<Point> points, String name, Color color) {
        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points, name, color);
        LOGGER.info(multiAngleFigure.toString() + " was created");
        MultiAngleFigureStorage.multiAngleFigureStorage.add(multiAngleFigure);
        return multiAngleFigure;
    }
}
