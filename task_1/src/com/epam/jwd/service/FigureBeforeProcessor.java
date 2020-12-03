package com.epam.jwd.service;

import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureBeforeProcessor {
    boolean process(List<Point> points);
}
