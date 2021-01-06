package com.epam.jwd.task.model.factory.impl.subfigure;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.storage.MultiAngleFigureStorage;
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
