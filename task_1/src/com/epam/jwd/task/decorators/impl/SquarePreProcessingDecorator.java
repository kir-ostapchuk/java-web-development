package com.epam.jwd.task.decorators.impl;

import com.epam.jwd.task.decorators.PreProcessingDecorator;
import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.factories.impl.square.Square;
import com.epam.jwd.task.preprocessors.impl.SquareExistencePreProcessor;

import java.util.Collections;

public class SquarePreProcessingDecorator extends PreProcessingDecorator<Square> {

    public SquarePreProcessingDecorator(FigureFactory<Square> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new SquareExistencePreProcessor()));
    }
}
