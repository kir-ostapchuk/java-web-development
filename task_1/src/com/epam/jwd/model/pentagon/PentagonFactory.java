package com.epam.jwd.model.pentagon;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.PentagonExistenceBeforeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PentagonFactory implements FigureFactory<Pentagon> {

    private static final Logger LOGGER = LogManager.getLogger(PentagonFactory.class);

    @Override
    public Pentagon createFigure(List<Point> points) throws FigureNotExistException {
        PentagonExistenceBeforeProcessor processor = new PentagonExistenceBeforeProcessor();
        boolean isCreatable = processor.process(points);
        if (!isCreatable) {
            throw new FigureNotExistException("Pentagon: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + ", " +
                    points.get(3).toString() + ", " +
                    points.get(4).toString() + " was NOT created");

        }
        LOGGER.info("Pentagon: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + ", " +
                points.get(3).toString() + ", " +
                points.get(4).toString() + " was created");
        return new Pentagon(points);
    }
}
