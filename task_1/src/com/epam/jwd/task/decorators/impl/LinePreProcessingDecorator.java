package com.epam.jwd.task.decorators.impl;

import com.epam.jwd.task.decorators.PreProcessingDecorator;
import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.factories.impl.line.Line;
import com.epam.jwd.task.preprocessors.impl.LineExistencePreProcessor;

import java.util.Collections;

public class LinePreProcessingDecorator extends PreProcessingDecorator<Line> {

    public LinePreProcessingDecorator(FigureFactory<Line> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new LineExistencePreProcessor()));
    }
}
