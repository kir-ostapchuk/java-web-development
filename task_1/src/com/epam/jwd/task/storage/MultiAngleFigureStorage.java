package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factory.impl.subfigure.MultiAngleFigure;

import java.util.ArrayList;
import java.util.List;

public final class MultiAngleFigureStorage extends FigureStorage<MultiAngleFigure> {

    public static List<MultiAngleFigure> multiAngleFigureStorage = new ArrayList<>();

    public MultiAngleFigureStorage() {
        super(multiAngleFigureStorage);
    }
}
