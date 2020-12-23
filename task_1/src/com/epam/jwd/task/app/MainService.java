package com.epam.jwd.task.app;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.context.impl.LineApplicationContext;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.factories.FigureFactory;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.model.factories.impl.line.LineFactory;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.model.Color;

import java.util.ArrayList;
import java.util.List;

class MainService {
    private MainService() {
        throw new AssertionError();
    }

//    public static List<Point> createPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {
//
//        List<Point> points = new ArrayList<>();
//        for (int i = 0; i < xCoordinates.size(); i++) {
//            points.add(new Point(xCoordinates.get(i), yCoordinates.get(i)));
//        }
//        return points;
//    }
//
//    public static List<Line> createLines(List<Integer> xCoordinates,
//                                         List<Integer> yCoordinates,
//                                         String name,
//                                         Color color)
//            throws FigureException {
//
//        final ApplicationContext<Line> lineApplicationContext = new LineApplicationContext();
//        final FigureFactory<Line> lineFactory =
//                lineApplicationContext.createFigureFactory(LineFactory.INSTANCE);
//        List<Line> lines = new ArrayList<>();
//
//        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
//        List<Point> twoPoints;
//        FigureCrud<Line> crud = new FigureCrud<>(new LineApplicationContext(), lineFactory, new LineStorage());
//
//        for (int i = 0; i <= allPoints.size() - 2; i += 2) {
//            twoPoints = allPoints.subList(i, i + 2);
//            lines.add(crud.create(twoPoints, name, color));
//        }
//        return lines;
//    }

//    public static List<Optional<Triangle>> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates)
//            throws FigureException {
//
//        final ApplicationContext<Triangle> lineApplicationContext = new TriangleApplicationContext();
//        FigureFactory<Triangle> triangleFactory = lineApplicationContext.createFigureFactory(TriangleFactory.INSTANCE);
//        List<Optional<Triangle>> triangles = new ArrayList<>();
//
//        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
//        List<Point> threePoints;
//
//        for (int i = 0; i <= allPoints.size() - 3; i += 3) {
//            threePoints = allPoints.subList(i, i + 3);
//            triangles.add(triangleFactory.createFigure(threePoints));
//        }
//        return triangles;
//    }
//
//    public static List<Optional<Square>> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates)
//            throws FigureException {
//
//        final ApplicationContext<Square> squareApplicationContext = new SquareApplicationContext();
//        final FigureFactory<Square> squareFactory =
//                squareApplicationContext.createFigureFactory(SquareFactory.INSTANCE);
//        List<Optional<Square>> squares = new ArrayList<>();
//
//        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
//        List<Point> fourPoints;
//
//        for (int i = 0; i <= allPoints.size() - 4; i += 4) {
//            fourPoints = allPoints.subList(i, i + 4);
//            squares.add(squareFactory.createFigure(fourPoints));
//        }
//        return squares;
//    }
//
//    public static List<Optional<MultiAngleFigure>> createMultiAngleFigures(List<Integer> xCoordinates, List<Integer> yCoordinates)
//            throws FigureException {
//
//        final ApplicationContext<MultiAngleFigure> multiAngleApplicationContext = new MultiAngleApplicationContext();
//        final FigureFactory<MultiAngleFigure> multiAngleFactory =
//                multiAngleApplicationContext.createFigureFactory(MultiAngleFigureFactory.INSTANCE);
//        List<Optional<MultiAngleFigure>> pentagons = new ArrayList<>();
//
//        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
//        List<Point> fivePoints;
//
//        for (int i = 0; i <= allPoints.size() - 5; i += 5) {
//            fivePoints = allPoints.subList(i, i + 5);
//            pentagons.add(multiAngleFactory.createFigure(fivePoints));
//        }
//        return pentagons;
//    }
}
