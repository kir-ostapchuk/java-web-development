package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.PreProcessingDecorator;
import com.epam.jwd.task.view.factory.FigureFactory;
import com.epam.jwd.task.view.factory.impl.line.Line;
import com.epam.jwd.task.preprocessor.impl.LineExistencePreProcessor;

import java.util.Collections;

public class LinePreProcessingDecorator extends PreProcessingDecorator<Line> {

    public LinePreProcessingDecorator(FigureFactory<Line> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new LineExistencePreProcessor()));
    }
}
