package com.epam.jwd.task.decorators;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.square.Square;
import com.epam.jwd.task.preprocessors.impl.SquareExistencePreProcessor;

import java.util.Collections;

public class SquarePreProcessingDecorator extends PreProcessingDecorator<Square> {

    public SquarePreProcessingDecorator(FigureFactory<Square> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new SquareExistencePreProcessor()));
    }
}
