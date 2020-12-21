package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorators.impl.LinePreProcessingDecorator;
import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.line.Line;

public class LineApplicationContext implements ApplicationContext<Line> {
    @Override
    public FigureFactory<Line> createFigureFactory(FigureFactory<Line> figureFactory) {
        return new LinePreProcessingDecorator(figureFactory);
    }
}
