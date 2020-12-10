package com.epam.jwd.decorators;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.triangle.Triangle;
import com.epam.jwd.preprocessors.impl.TriangleExistencePreProcessor;

import java.util.Collections;

public class TrianglePreProcessingDecorator extends PreProcessingDecorator<Triangle> {

    public TrianglePreProcessingDecorator(FigureFactory<Triangle> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new TriangleExistencePreProcessor()));
    }
}
