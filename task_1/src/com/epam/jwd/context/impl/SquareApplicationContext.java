package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationContext;
import com.epam.jwd.decorators.SquarePreProcessingDecorator;
import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.square.Square;

public class SquareApplicationContext implements ApplicationContext<Square> {
    @Override
    public FigureFactory<Square> createFigureFactory(FigureFactory<Square> figureFactory) {
        return new SquarePreProcessingDecorator(figureFactory);
    }
}
