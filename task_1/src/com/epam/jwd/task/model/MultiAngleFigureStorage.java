package com.epam.jwd.task.model;

import com.epam.jwd.task.view.factory.impl.subfigure.MultiAngleFigure;

import java.util.ArrayList;
import java.util.List;

public final class MultiAngleFigureStorage extends FigureStorage<MultiAngleFigure> {

    public static List<MultiAngleFigure> multiAngleFigureStorage = new ArrayList<>();

    public MultiAngleFigureStorage() {
        super(multiAngleFigureStorage);
    }
}
