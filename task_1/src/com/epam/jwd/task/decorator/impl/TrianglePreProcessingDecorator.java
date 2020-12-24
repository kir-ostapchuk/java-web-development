package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.PreProcessingDecorator;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.triangle.Triangle;
import com.epam.jwd.task.preprocessor.impl.TriangleExistencePreProcessor;

import java.util.Collections;

public class TrianglePreProcessingDecorator extends PreProcessingDecorator<Triangle> {

    public TrianglePreProcessingDecorator(FigureFactory<Triangle> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new TriangleExistencePreProcessor()));
    }
}
