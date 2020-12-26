package com.epam.jwd.task.service;

import com.epam.jwd.task.model.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareService {
    public static List<Double> calculateAllSidesForSquare(Point point1, Point point2,
                                                           Point point3, Point point4) {
        List<Double> sides = new ArrayList<>();
        sides.add(FigureService.calculateSide(point1, point2));
        sides.add(FigureService.calculateSide(point2, point3));
        sides.add(FigureService.calculateSide(point3, point4));
        sides.add(FigureService.calculateSide(point1, point4));
        sides.add(FigureService.calculateSide(point2, point4));
        sides.add(FigureService.calculateSide(point1, point3));
        Collections.sort(sides);
        return sides;
    }
}
