package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.PreProcessingDecorator;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.square.Square;
import com.epam.jwd.task.preprocessor.impl.SquareExistencePreProcessor;

import java.util.Collections;

public class SquarePreProcessingDecorator extends PreProcessingDecorator<Square> {

    public SquarePreProcessingDecorator(FigureFactory<Square> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new SquareExistencePreProcessor()));
    }
}
