package com.epam.jwd.task.decorators.impl;

import com.epam.jwd.task.decorators.PreProcessingDecorator;
import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.factories.impl.triangle.Triangle;
import com.epam.jwd.task.preprocessors.impl.TriangleExistencePreProcessor;

import java.util.Collections;

public class TrianglePreProcessingDecorator extends PreProcessingDecorator<Triangle> {

    public TrianglePreProcessingDecorator(FigureFactory<Triangle> figureFactory) {
        super(figureFactory);
        System.out.println("TRIANGLE PREPROCESSOR");
        setPreProcessors(Collections.singletonList(
                new TriangleExistencePreProcessor()));
    }
}
