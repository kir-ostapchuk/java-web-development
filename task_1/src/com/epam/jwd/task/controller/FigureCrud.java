package com.epam.jwd.task.controller;

import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.view.Figure;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.view.factories.FigureFactory;
import com.epam.jwd.task.view.Color;
import com.epam.jwd.task.view.factories.impl.line.LineFactory;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.model.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        if (storage.removeAll(figure)) {
            LOGGER.info("Figures were removed");
        }
        return storage.removeAll(figure);
    }

    public List<T> find(T figure) {
        if (storage.find(figure).isEmpty()) {
            LOGGER.info("No figures were found");
        } else {
            LOGGER.info("Were found: " + storage.find(figure).size() + " figures");
        }
        return storage.find(figure);
    }

    public T findById(UUID id) throws FigureNotExistException {
        return storage.findById(id)
                .orElseThrow(() -> new FigureNotExistException("No figure in the storage"));
    }

    public List<T> findBySpecification(Specification specification) {
        if (storage.findBySpecification(specification).isEmpty()) {
            LOGGER.info("No figures were found");
        } else {
            LOGGER.info("Were found: " + storage.findBySpecification(specification).size() + " figures");
        }
        return storage.findBySpecification(specification);
    }
}
