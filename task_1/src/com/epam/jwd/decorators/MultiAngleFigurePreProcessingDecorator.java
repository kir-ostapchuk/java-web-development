package com.epam.jwd.decorators;

import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.preprocessors.impl.MultiAngleFigureExistencePreProcessor;

import java.util.Collections;

public class MultiAngleFigurePreProcessingDecorator extends PreProcessingDecorator<MultiAngleFigure> {

    public MultiAngleFigurePreProcessingDecorator(FigureFactory<MultiAngleFigure> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new MultiAngleFigureExistencePreProcessor()));
    }
}
