package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorators.impl.SquarePreProcessingDecorator;
import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.square.Square;

public class SquareApplicationContext implements ApplicationContext<Square> {
    @Override
    public FigureFactory<Square> createFigureFactory(FigureFactory<Square> figureFactory) {
        return new SquarePreProcessingDecorator(figureFactory);
    }
}
