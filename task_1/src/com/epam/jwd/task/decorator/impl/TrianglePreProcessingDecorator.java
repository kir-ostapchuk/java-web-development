package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.PreProcessingDecorator;
import com.epam.jwd.task.view.factory.FigureFactory;
import com.epam.jwd.task.view.factory.impl.triangle.Triangle;
import com.epam.jwd.task.preprocessor.impl.TriangleExistencePreProcessor;

import java.util.Collections;

public class TrianglePreProcessingDecorator extends PreProcessingDecorator<Triangle> {

    public TrianglePreProcessingDecorator(FigureFactory<Triangle> figureFactory) {
        super(figureFactory);
        System.out.println("TRIANGLE PREPROCESSOR");
        setPreProcessors(Collections.singletonList(
                new TriangleExistencePreProcessor()));
    }
}
