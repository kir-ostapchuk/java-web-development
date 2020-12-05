package com.epam.jwd.model.subfigures;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.preprocessor.MultiAngleFigureExistencePreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum MultiAngleFigureFactory implements FigureFactory<MultiAngleFigure> {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigureFactory.class);

    @Override
    public MultiAngleFigure createFigure(List<Point> points) throws FigureNotExistException {
        MultiAngleFigureExistencePreProcessor processor = new MultiAngleFigureExistencePreProcessor();
        boolean isCreatable = processor.process(points);
        if (!isCreatable) {
            throw new FigureNotExistException("MultiAngleFigure with " + points.size() + " was NOT created");

        }
        LOGGER.info("MultiAngleFigure with " + points.size() + " was created");
        return new MultiAngleFigure(points);
    }
}
