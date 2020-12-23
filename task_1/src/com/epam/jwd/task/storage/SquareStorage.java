package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factories.impl.square.Square;

import java.util.ArrayList;
import java.util.List;

public final class SquareStorage extends FigureStorage<Square> {
    public static List<Square> squareStorage = new ArrayList<>();

    public SquareStorage() {
        super(squareStorage);
    }
}
