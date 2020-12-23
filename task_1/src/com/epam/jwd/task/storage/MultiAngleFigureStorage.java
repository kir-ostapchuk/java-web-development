package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;

import java.util.ArrayList;
import java.util.List;

public class MultiAngleFigureStorage extends FigureStorage<MultiAngleFigure> {
    public static List<MultiAngleFigure> multiAngleFigureStorage = new ArrayList<>();

    public MultiAngleFigureStorage() {
        super(multiAngleFigureStorage);
    }
}
