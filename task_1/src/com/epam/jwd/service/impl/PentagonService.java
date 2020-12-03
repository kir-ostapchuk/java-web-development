package com.epam.jwd.service.impl;

import com.epam.jwd.model.pentagon.Pentagon;
import com.epam.jwd.service.MultiAngleFigureService;
import com.epam.jwd.strategy.PentagonCalculator;

public class PentagonService implements MultiAngleFigureService<Pentagon> {
    private PentagonCalculator strategy;

    @Override
    public double calculateArea(Pentagon pentagon) {
        return strategy.calculateArea(pentagon);
    }

    @Override
    public double calculatePerimeter(Pentagon pentagon) {
        return strategy.calculatePerimeter(pentagon);
    }
}
