package com.epam.jwd.task.model.factories.impl.subfigures;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum MultiAngleFigureFactory implements FigureFactory<MultiAngleFigure> {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigureFactory.class);

    @Override
    public MultiAngleFigure createFigure(List<Point> points) {
        LOGGER.info("MultiAngleFigure with " + points.size() + " points was created");
        return new MultiAngleFigure(points);
    }
}
