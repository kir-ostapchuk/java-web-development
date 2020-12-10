package com.epam.jwd.task.decorators;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.preprocessors.impl.TriangleExistencePreProcessor;

import java.util.Collections;

public class TrianglePreProcessingDecorator extends PreProcessingDecorator<Triangle> {

    public TrianglePreProcessingDecorator(FigureFactory<Triangle> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new TriangleExistencePreProcessor()));
    }
}
