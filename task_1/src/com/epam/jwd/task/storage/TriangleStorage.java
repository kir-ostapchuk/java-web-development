package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.factory.impl.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;

public final class TriangleStorage extends FigureStorage<Triangle> {

    public static List<Triangle> triangleStorage = new ArrayList<>();

    public TriangleStorage() {
        super(triangleStorage);
    }
}