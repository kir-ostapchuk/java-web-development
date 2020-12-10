package com.epam.jwd.app;

import com.epam.jwd.context.ApplicationContext;
import com.epam.jwd.context.impl.LineApplicationContext;
import com.epam.jwd.context.impl.MultiAngleApplicationContext;
import com.epam.jwd.context.impl.SquareApplicationContext;
import com.epam.jwd.context.impl.TriangleApplicationContext;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.factories.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factories.impl.line.Line;
import com.epam.jwd.model.factories.impl.line.LineFactory;
import com.epam.jwd.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.model.factories.impl.subfigures.MultiAngleFigureFactory;
import com.epam.jwd.model.factories.impl.square.Square;
import com.epam.jwd.model.factories.impl.square.SquareFactory;
import com.epam.jwd.model.factories.impl.triangle.Triangle;
import com.epam.jwd.model.factories.impl.triangle.TriangleFactory;

import java.util.ArrayList;
import java.util.List;

class MainService {
    private MainService() {
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
            throws FigureException {

        final ApplicationContext<Line> lineApplicationContext = new LineApplicationContext();
        final FigureFactory<Line> lineFactory =
                lineApplicationContext.createFigureFactory(LineFactory.INSTANCE);
        List<Line> lines = new ArrayList<>();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> twoPoints;

        for (int i = 0; i <= allPoints.size() - 2; i += 2) {
            twoPoints = allPoints.subList(i, i + 2);
            lines.add(lineFactory.createFigure(twoPoints));
        }
        return lines;
    }

    public static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureException {

        final ApplicationContext<Triangle> lineApplicationContext = new TriangleApplicationContext();
        FigureFactory<Triangle> triangleFactory = lineApplicationContext.createFigureFactory(TriangleFactory.INSTANCE);
        List<Triangle> triangles = new ArrayList<>();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> threePoints;

        for (int i = 0; i <= allPoints.size() - 3; i += 3) {
            threePoints = allPoints.subList(i, i + 3);
            triangles.add(triangleFactory.createFigure(threePoints));
        }
        return triangles;
    }

    public static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureException {

        final ApplicationContext<Square> squareApplicationContext = new SquareApplicationContext();
        final FigureFactory<Square> squareFactory =
                squareApplicationContext.createFigureFactory(SquareFactory.INSTANCE);
        List<Square> squares = new ArrayList<>();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fourPoints;

        for (int i = 0; i <= allPoints.size() - 4; i += 4) {
            fourPoints = allPoints.subList(i, i + 4);
            squares.add(squareFactory.createFigure(fourPoints));
        }
        return squares;
    }

    public static List<MultiAngleFigure> createMultiAngleFigures(List<Integer> xCoordinates, List<Integer> yCoordinates)
            throws FigureException {

        final ApplicationContext<MultiAngleFigure> multiAngleApplicationContext = new MultiAngleApplicationContext();
        final FigureFactory<MultiAngleFigure> multiAngleFactory =
                multiAngleApplicationContext.createFigureFactory(MultiAngleFigureFactory.INSTANCE);
        List<MultiAngleFigure> pentagons = new ArrayList<>();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fivePoints;

        for (int i = 0; i <= allPoints.size() - 5; i += 5) {
            fivePoints = allPoints.subList(i, i + 5);
            pentagons.add(multiAngleFactory.createFigure(fivePoints));
        }

        return pentagons;
    }
}
