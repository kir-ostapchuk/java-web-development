package com.epam.jwd.task.specification;

import com.epam.jwd.task.calculations.impl.SquareCalculator;
import com.epam.jwd.task.calculations.impl.TriangleCalculator;
import com.epam.jwd.task.view.Color;
import com.epam.jwd.task.view.Figure;
import com.epam.jwd.task.view.factories.impl.square.Square;
import com.epam.jwd.task.view.factories.impl.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Specification {

    private final String name;
    private final String startName;
    private final Color color;
    private final double greaterArea;
    private final double lessArea;
    private final int greaterPerimeter;

    private final boolean isCheckedName;
    private final boolean isCheckedStartName;
    private final boolean isCheckedColor;
    private final boolean isCheckedGreaterArea;
    private final boolean isCheckedLessArea;
    private final boolean isCheckedGreaterPerimeter;

    private Specification(String name,
                          String startName,
                          Color color,
                          double greaterArea,
                          double lessArea,
                          int greaterPerimeter,

                          boolean isCheckedName,
                          boolean isCheckedStartName,
                          boolean isCheckedColor,
                          boolean isCheckedGreaterArea,
                          boolean isCheckedLessArea,
                          boolean isCheckedGreaterPerimeter) {

        this.name = name;
        this.startName = startName;
        this.color = color;
        this.greaterArea = greaterArea;
        this.lessArea = lessArea;
        this.greaterPerimeter = greaterPerimeter;

        this.isCheckedName = isCheckedName;
        this.isCheckedStartName = isCheckedStartName;
        this.isCheckedColor = isCheckedColor;
        this.isCheckedGreaterArea = isCheckedGreaterArea;
        this.isCheckedLessArea = isCheckedLessArea;
        this.isCheckedGreaterPerimeter = isCheckedGreaterPerimeter;
    }

    public static class Builder {

        private String name;
        private String startName;
        private Color color;
        private double greaterArea;
        private double lessArea;
        private int greaterPerimeter;

        private boolean isCheckedName = false;
        private boolean isCheckedStartName = false;
        private boolean isCheckedColor = false;
        private boolean isCheckedGreaterArea = false;
        private boolean isCheckedLessArea = false;
        private boolean isCheckedGreaterPerimeter = false;

        public Builder whereName(String name) {
            isCheckedName = true;
            this.name = name;
            return this;
        }

        public Builder whereNameStartsWith(String startName) {
            isCheckedStartName = true;
            this.startName = startName;
            return this;
        }

        public Builder whereColor(Color color) {
            isCheckedColor = true;
            this.color = color;
            return this;
        }

        public Builder whereAreaGreater(double area) {
            isCheckedGreaterArea = true;
            this.greaterArea = area;
            return this;
        }

        public Builder whereAreaLessThan(double area) {
            isCheckedLessArea = true;
            this.lessArea = area;
            return this;
        }

        public Builder wherePerimeterGreater(int perimeter) {
            isCheckedGreaterPerimeter = true;
            this.greaterPerimeter = perimeter;
            return this;
        }

        public Specification build() {
            return new Specification(name,
                    startName,
                    color,
                    greaterArea,
                    lessArea,
                    greaterPerimeter,

                    isCheckedName,
                    isCheckedStartName,
                    isCheckedColor,
                    isCheckedGreaterArea,
                    isCheckedLessArea,
                    isCheckedGreaterPerimeter);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean matches(Figure figure) {
        List<Boolean> checkedCriteria = new ArrayList<>();
        if (isCheckedColor) {
            checkedCriteria.add(this.color.equals(figure.getColor()));
        }
        if (isCheckedStartName) {
            checkedCriteria.add(figure.getName().startsWith(startName));
        }
        if (isCheckedName) {
            checkedCriteria.add(this.name.equals(figure.getName()));
        }
        if (isCheckedGreaterArea) {
            if (figure instanceof Triangle) {
                double area = TriangleCalculator.INSTANCE.calculateArea((Triangle) figure);
                checkedCriteria.add(this.greaterArea < area);
            }
            if (figure instanceof Square) {
                double area = SquareCalculator.INSTANCE.calculateArea((Square) figure);
                checkedCriteria.add(this.greaterArea < area);
            }
        }
        if (isCheckedLessArea) {
            if (figure instanceof Triangle) {
                double area = TriangleCalculator.INSTANCE.calculateArea((Triangle) figure);
                checkedCriteria.add(this.lessArea > area);
            }
            if (figure instanceof Square) {
                double area = SquareCalculator.INSTANCE.calculateArea((Square) figure);
                checkedCriteria.add(this.lessArea > area);
            }
        }
        if (isCheckedGreaterPerimeter) {
            if (figure instanceof Triangle) {
                double perimeter = TriangleCalculator.INSTANCE.calculatePerimeter((Triangle) figure);
                checkedCriteria.add(this.greaterPerimeter < perimeter);
            }
            if (figure instanceof Square) {
                double perimeter = SquareCalculator.INSTANCE.calculatePerimeter((Square) figure);
                checkedCriteria.add(this.greaterPerimeter < perimeter);
            }
        }

        if (checkedCriteria.isEmpty()) {
            return false;
        }
        return checkedCriteria.stream().filter(b -> !b).findFirst().orElse(true);
    }
}
