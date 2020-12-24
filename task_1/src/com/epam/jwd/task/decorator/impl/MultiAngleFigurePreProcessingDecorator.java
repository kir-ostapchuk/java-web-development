package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.PreProcessingDecorator;
import com.epam.jwd.task.view.factory.FigureFactory;
import com.epam.jwd.task.view.factory.impl.subfigure.MultiAngleFigure;
import com.epam.jwd.task.preprocessor.impl.MultiAngleFigureExistencePreProcessor;

import java.util.Collections;

public class MultiAngleFigurePreProcessingDecorator extends PreProcessingDecorator<MultiAngleFigure> {

    public MultiAngleFigurePreProcessingDecorator(FigureFactory<MultiAngleFigure> figureFactory) {
        super(figureFactory);
        setPreProcessors(Collections.singletonList(
                new MultiAngleFigureExistencePreProcessor()));
    }
}
