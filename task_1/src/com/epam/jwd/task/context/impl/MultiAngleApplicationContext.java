package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorators.MultiAngleFigurePreProcessingDecorator;
import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;

public class MultiAngleApplicationContext implements ApplicationContext<MultiAngleFigure> {
    @Override
    public FigureFactory<MultiAngleFigure> createFigureFactory(FigureFactory<MultiAngleFigure> figureFactory) {
        return new MultiAngleFigurePreProcessingDecorator(figureFactory);
    }
}
