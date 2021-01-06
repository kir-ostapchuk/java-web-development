package com.epam.jwd.task.crud;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.FigureFactory;
import com.epam.jwd.task.model.factory.impl.line.LineFactory;
import com.epam.jwd.task.specification.SpecificationMatcher;
import com.epam.jwd.task.storage.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class FigureCrud<T extends Figure> {

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    private final FigureFactory<T> factory;
    private final FigureStorage<T> storage;

    public FigureCrud(ApplicationContext<T> context, FigureFactory<T> factory, FigureStorage<T> storage) {
        this.factory = context.createFigureFactory(factory);
        this.storage = storage;
    }

    public T create(List<Point> points, String name, Color color) throws FigureException {
        return factory.createFigure(points, name, color);
    }

    public List<T> multiCreate(List<Point> points, int amountToCreate, String generalName, Color generalColor)
            throws FigureException {
        List<T> figures = new ArrayList<>();
        if (points != null && amountToCreate > 0) {
            for (int i = 0; i < amountToCreate; i++) {
                figures.add(factory.createFigure(points, generalName, generalColor));
            }
        }
        return figures;
    }

    public boolean removeAll(T figure) {
        boolean isRemoved = storage.removeAll(figure);
        if (isRemoved) {
            LOGGER.info("Figures were removed");
        }
        return isRemoved;
    }

    public List<T> find(T figure) {
        List<T> foundFigures = storage.find(figure);
        if (foundFigures.isEmpty()) {
            LOGGER.info("No figures were found");
        } else {
            LOGGER.info("Were found: " + foundFigures.size() + " figures");
        }
        return foundFigures;
    }

    public T findById(UUID id) throws FigureNotExistException {
        return storage.findById(id).orElseThrow(() -> new FigureNotExistException("No figure in the storage"));
    }

    public List<T> findBySpecification(SpecificationMatcher specification) {
        List<T> foundFigures = storage.findBySpecification(specification);
        if (foundFigures.isEmpty()) {
            LOGGER.info("No figures were found");
        } else {
            LOGGER.info("Were found: " + foundFigures.size() + " figures");
        }
        return foundFigures;
    }

    public List<T> findBy(Predicate<T> p) {
        return storage.findBy(p);
    }
}
