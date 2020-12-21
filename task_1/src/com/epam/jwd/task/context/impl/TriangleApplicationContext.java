package com.epam.jwd.task.context.impl;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.decorators.impl.TrianglePreProcessingDecorator;
import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;

public class TriangleApplicationContext implements ApplicationContext<Triangle> {
    @Override
    public FigureFactory<Triangle> createFigureFactory(FigureFactory<Triangle> figureFactory) {
        return new TrianglePreProcessingDecorator(figureFactory);
    }
}
