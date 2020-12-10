package com.epam.jwd.context;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.factories.FigureFactory;

public interface ApplicationContext<T extends Figure> {
    FigureFactory<T> createFigureFactory(FigureFactory<T> figureFactory);
}
