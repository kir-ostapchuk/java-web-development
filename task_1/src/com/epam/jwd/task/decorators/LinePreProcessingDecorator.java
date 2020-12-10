package com.epam.jwd.task.decorators;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.preprocessors.impl.LineExistencePreProcessor;

import java.util.Collections;

public class LinePreProcessingDecorator extends PreProcessingDecorator<Line> {

    public LinePreProcessingDecorator(FigureFactory<Line> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new LineExistencePreProcessor()));
    }
}
