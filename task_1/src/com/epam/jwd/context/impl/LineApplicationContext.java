package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationContext;
import com.epam.jwd.decorators.LinePreProcessingDecorator;
import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.line.Line;

public class LineApplicationContext implements ApplicationContext<Line> {
    @Override
    public FigureFactory<Line> createFigureFactory(FigureFactory<Line> figureFactory) {
        return new LinePreProcessingDecorator(figureFactory);
    }
}
