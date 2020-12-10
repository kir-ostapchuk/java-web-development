package com.epam.jwd.task.decorators;

import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.task.preprocessors.impl.MultiAngleFigureExistencePreProcessor;

import java.util.Collections;

public class MultiAngleFigurePreProcessingDecorator extends PreProcessingDecorator<MultiAngleFigure> {

    public MultiAngleFigurePreProcessingDecorator(FigureFactory<MultiAngleFigure> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new MultiAngleFigureExistencePreProcessor()));
    }
}
