package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationContext;
import com.epam.jwd.decorators.MultiAngleFigurePreProcessingDecorator;
import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.subfigures.MultiAngleFigure;

public class MultiAngleApplicationContext implements ApplicationContext<MultiAngleFigure> {
    @Override
    public FigureFactory<MultiAngleFigure> createFigureFactory(FigureFactory<MultiAngleFigure> figureFactory) {
        return new MultiAngleFigurePreProcessingDecorator(figureFactory);
    }
}
