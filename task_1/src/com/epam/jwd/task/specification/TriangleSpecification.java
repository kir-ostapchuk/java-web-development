package com.epam.jwd.task.specification;

import com.epam.jwd.task.calculation.impl.TriangleCalculator;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.factory.impl.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleSpecification implements Specification {

    private final String name;
    private final String startName;
    private final Color color;
    private final Double greaterArea;
    private final Double lessArea;
    private final Integer greaterPerimeter;

    private TriangleSpecification(String name,
                          String startName,
                          Color color,
                          Double greaterArea,
                          Double lessArea,
                          Integer greaterPerimeter) {
        this.name = name;
        this.startName = startName;
        this.color = color;
        this.greaterArea = greaterArea;
        this.lessArea = lessArea;
        this.greaterPerimeter = greaterPerimeter;
    }

    public static class Builder {

        private String name;
        private String startName;
        private Color color;
        private Double greaterArea;
        private Double lessArea;
        private Integer greaterPerimeter;

        public Builder whereName(String name) {
            this.name = name;
            return this;
        }

        public Builder whereNameStartsWith(String startName) {
            this.startName = startName;
            return this;
        }

        public Builder whereColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder whereAreaGreater(Double area) {
            this.greaterArea = area;
            return this;
        }

        public Builder whereAreaLessThan(Double area) {
            this.lessArea = area;
            return this;
        }

        public Builder wherePerimeterGreater(Integer perimeter) {
            this.greaterPerimeter = perimeter;
            return this;
        }

        public TriangleSpecification build() {
            return new TriangleSpecification(name,
                    startName,
                    color,
                    greaterArea,
                    lessArea,
                    greaterPerimeter);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean matches(Figure figure) {
        List<Boolean> checkedCriteria = new ArrayList<>();
        if (color != null) {
            checkedCriteria.add(this.color.equals(figure.getColor()));
        }
        if (startName != null) {
            checkedCriteria.add(figure.getName().startsWith(startName));
        }
        if (name != null) {
            checkedCriteria.add(this.name.equals(figure.getName()));
        }
        if (greaterArea != null) {
            double area = TriangleCalculator.INSTANCE.calculateArea((Triangle) figure);
            checkedCriteria.add(this.greaterArea < area);
        }
        if (lessArea != null) {
            double area = TriangleCalculator.INSTANCE.calculateArea((Triangle) figure);
            checkedCriteria.add(this.lessArea > area);
        }
        if (greaterPerimeter != null) {
            double perimeter = TriangleCalculator.INSTANCE.calculatePerimeter((Triangle) figure);
            checkedCriteria.add(this.greaterPerimeter < perimeter);
        }

        if (checkedCriteria.isEmpty()) {
            return false;
        }
        return checkedCriteria.stream().filter(b -> !b).findFirst().orElse(true);
    }
}
