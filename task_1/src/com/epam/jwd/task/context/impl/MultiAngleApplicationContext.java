package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorator.impl.MultiAngleFigurePreProcessingDecorator;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.subfigure.MultiAngleFigure;

public class MultiAngleApplicationContext implements ApplicationContext<MultiAngleFigure> {
    @Override
    public FigureFactory<MultiAngleFigure> createFigureFactory(FigureFactory<MultiAngleFigure> figureFactory) {
        return new MultiAngleFigurePreProcessingDecorator(figureFactory);
    }
}
