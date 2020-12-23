package com.epam.jwd.task.model;

import com.epam.jwd.task.view.factories.impl.square.Square;

import java.util.ArrayList;
import java.util.List;

public final class SquareStorage extends FigureStorage<Square> {

    public static List<Square> squareStorage = new ArrayList<>();

    public SquareStorage() {
        super(squareStorage);
    }
}
