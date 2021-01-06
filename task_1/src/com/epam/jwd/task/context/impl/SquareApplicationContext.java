package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorator.impl.SquarePreProcessingDecorator;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.square.Square;

public class SquareApplicationContext implements ApplicationContext<Square> {

    @Override
    public FigureFactory<Square> createFigureFactory(FigureFactory<Square> figureFactory) {
        return new SquarePreProcessingDecorator(figureFactory);
    }
}
