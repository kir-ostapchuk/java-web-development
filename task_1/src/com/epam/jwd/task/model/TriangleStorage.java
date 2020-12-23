package com.epam.jwd.task.model;

import com.epam.jwd.task.view.factories.impl.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;

public final class TriangleStorage extends FigureStorage<Triangle> {

    public static List<Triangle> triangleStorage = new ArrayList<>();

    public TriangleStorage() {
        super(triangleStorage);
    }
}