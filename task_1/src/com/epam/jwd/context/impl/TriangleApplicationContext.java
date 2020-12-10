package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationContext;
import com.epam.jwd.decorators.TrianglePreProcessingDecorator;
import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.triangle.Triangle;

public class TriangleApplicationContext implements ApplicationContext<Triangle> {
    @Override
    public FigureFactory<Triangle> createFigureFactory(FigureFactory<Triangle> figureFactory) {
        return new TrianglePreProcessingDecorator(figureFactory);
    }
}
