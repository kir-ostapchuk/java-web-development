package com.epam.jwd.decorators;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.square.Square;
import com.epam.jwd.preprocessors.impl.SquareExistencePreProcessor;

import java.util.Collections;

public class SquarePreProcessingDecorator extends PreProcessingDecorator<Square> {

    public SquarePreProcessingDecorator(FigureFactory<Square> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new SquareExistencePreProcessor()));
    }
}
