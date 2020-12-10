package com.epam.jwd.decorators;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.line.Line;
import com.epam.jwd.preprocessors.impl.LineExistencePreProcessor;

import java.util.Collections;

public class LinePreProcessingDecorator extends PreProcessingDecorator<Line> {

    public LinePreProcessingDecorator(FigureFactory<Line> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new LineExistencePreProcessor()));
    }
}
