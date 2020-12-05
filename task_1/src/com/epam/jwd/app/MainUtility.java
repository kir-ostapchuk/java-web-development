package com.epam.jwd.app;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.line.Line;
import com.epam.jwd.model.line.LineFactory;
import com.epam.jwd.model.subfigures.MultiAngleFigure;
import com.epam.jwd.model.subfigures.MultiAngleFigureFactory;
import com.epam.jwd.model.square.Square;
import com.epam.jwd.model.square.SquareFactory;
import com.epam.jwd.model.triangle.Triangle;
import com.epam.jwd.model.triangle.TriangleFactory;

import java.util.ArrayList;
import java.util.List;

public class MainUtility {
    private MainUtility() {
        throw new AssertionError();
    }

    public static List<Point> createPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < xCoordinates.size(); i++) {
            points.add(new Point(xCoordinates.get(i), yCoordinates.get(i)));
        }
        return points;
    }

    public static List<Line> createLines(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureNotExistException {

        List<Line> lines = new ArrayList<>();
        LineFactory lineFactory = LineFactory.INSTANCE;

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> twoPoints;

        for (int i = 0; i <= allPoints.size() - 2; i += 2) {
            twoPoints = allPoints.subList(i, i + 2);
            lines.add(lineFactory.createFigure(twoPoints));
        }
        return lines;
    }

    public static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureNotExistException {

        List<Triangle> triangles = new ArrayList<>();
        TriangleFactory triangleFactory = TriangleFactory.INSTANCE;

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> threePoints;

        for (int i = 0; i <= allPoints.size() - 3; i += 3) {
            threePoints = allPoints.subList(i, i + 3);
            triangles.add(triangleFactory.createFigure(threePoints));
        }
        return triangles;
    }

    public static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureNotExistException {

        List<Square> squares = new ArrayList<>();
        SquareFactory squareFactory = SquareFactory.INSTANCE;

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fourPoints;

        for (int i = 0; i <= allPoints.size() - 4; i += 4) {
            fourPoints = allPoints.subList(i, i + 4);
            squares.add(squareFactory.createFigure(fourPoints));
        }
        return squares;
    }

    public static List<MultiAngleFigure> createMultiAngleFigures(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureNotExistException {

        List<MultiAngleFigure> pentagons = new ArrayList<>();
        MultiAngleFigureFactory multiAngleFigureFactory = MultiAngleFigureFactory.INSTANCE;

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fivePoints;

        for (int i = 0; i <= allPoints.size() - 5; i += 5) {
            fivePoints = allPoints.subList(i, i + 5);
            pentagons.add(multiAngleFigureFactory.createFigure(fivePoints));
        }

        return pentagons;
    }
}
