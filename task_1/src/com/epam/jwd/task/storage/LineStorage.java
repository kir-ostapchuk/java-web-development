package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factories.impl.line.Line;

import java.util.ArrayList;
import java.util.List;

public final class LineStorage  extends FigureStorage<Line> {
    public static List<Line> lineStorage = new ArrayList<>();

    public LineStorage() {
        super(lineStorage);
    }
}