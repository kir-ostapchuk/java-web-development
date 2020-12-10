package com.epam.jwd.task.decorators;

import com.epam.jwd.task.preprocessors.ExistencePreProcessor;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.FigureFactory;

import java.util.List;

public class PreProcessingDecorator<T extends Figure> implements FigureFactory<T> {

    private List<ExistencePreProcessor> preProcessors;

    private final FigureFactory<T> figureFactory;

    public PreProcessingDecorator(FigureFactory<T> figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void setPreProcessors(List<ExistencePreProcessor> preProcessors) {
        this.preProcessors = preProcessors;
    }

    @Override
    public T createFigure(List<Point> points) throws FigureException {
        for (ExistencePreProcessor preProcessor : preProcessors) {
            preProcessor.preProcess(points);
        }
        return figureFactory.createFigure(points);
    }
}
