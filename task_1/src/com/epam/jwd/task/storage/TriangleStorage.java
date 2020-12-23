package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factories.impl.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleStorage extends FigureStorage<Triangle> {
    public static List<Triangle> triangleStorage = new ArrayList<>();

    public TriangleStorage() {
        super(triangleStorage);
    }
}