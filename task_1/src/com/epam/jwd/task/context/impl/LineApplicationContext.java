package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorator.impl.LinePreProcessingDecorator;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.line.Line;

public class LineApplicationContext implements ApplicationContext<Line> {
    @Override
    public FigureFactory<Line> createFigureFactory(FigureFactory<Line> figureFactory) {
        return new LinePreProcessingDecorator(figureFactory);
    }
}
