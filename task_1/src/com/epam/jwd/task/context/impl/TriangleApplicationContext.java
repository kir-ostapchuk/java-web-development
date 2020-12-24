package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorator.impl.TrianglePreProcessingDecorator;
import com.epam.jwd.task.view.factory.FigureFactory;
import com.epam.jwd.task.view.factory.impl.triangle.Triangle;

public class TriangleApplicationContext implements ApplicationContext<Triangle> {
    @Override
    public FigureFactory<Triangle> createFigureFactory(FigureFactory<Triangle> figureFactory) {
        return new TrianglePreProcessingDecorator(figureFactory);
    }
}
