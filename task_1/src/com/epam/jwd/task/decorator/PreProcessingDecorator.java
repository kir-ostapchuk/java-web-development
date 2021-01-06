package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.preprocessor.ExistencePreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PreProcessingDecorator<T extends Figure> implements FigureFactory<T> {

    private static final Logger LOGGER = LogManager.getLogger(PreProcessingDecorator.class);

    private List<ExistencePreProcessor> preProcessors;

    private final FigureFactory<T> figureFactory;

    public PreProcessingDecorator(FigureFactory<T> figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void setPreProcessors(List<ExistencePreProcessor> preProcessors) {
        this.preProcessors = preProcessors;
    }

    @Override
    public T createFigure(List<Point> points, String name, Color color) throws FigureException {
        try {
            for (ExistencePreProcessor preProcessor : preProcessors) {
                preProcessor.preProcess(points);
            }
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
        }
        return figureFactory.createFigure(points, name, color);
    }
}
