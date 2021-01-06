package com.epam.jwd.task.context;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.factory.FigureFactory;

@FunctionalInterface
public interface ApplicationContext<T extends Figure> {

    FigureFactory<T> createFigureFactory(FigureFactory<T> figureFactory);
}
