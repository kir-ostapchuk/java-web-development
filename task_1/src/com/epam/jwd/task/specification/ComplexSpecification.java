package com.epam.jwd.task.specification;

import com.epam.jwd.task.calculation.impl.SquareCalculator;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.factory.impl.square.Square;

import java.util.ArrayList;
import java.util.List;

public class ComplexSpecification extends Specification {

    private final Double greaterArea;
    private final Double lessArea;
    private final Integer greaterPerimeter;

    public static class Builder extends Specification.Builder<Builder> {

        private Double greaterArea;
        private Double lessArea;
        private Integer greaterPerimeter;

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

        @Override
        public ComplexSpecification build() {
            return new ComplexSpecification(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public ComplexSpecification(Builder builder) {
        super(builder);
        this.greaterArea = builder.greaterArea;
        this.greaterPerimeter = builder.greaterPerimeter;
        this.lessArea = builder.lessArea;
    }

    public boolean matches(Figure figure) {
        List<Boolean> checkedCriteria = new ArrayList<>();
        if (greaterArea != null) {
            double area = SquareCalculator.INSTANCE.calculateArea((Square) figure);
            checkedCriteria.add(this.greaterArea < area);
        }
        if (lessArea != null) {
            double area = SquareCalculator.INSTANCE.calculateArea((Square) figure);
            checkedCriteria.add(this.lessArea > area);
        }
        if (greaterPerimeter != null) {
            double perimeter = SquareCalculator.INSTANCE.calculatePerimeter((Square) figure);
            checkedCriteria.add(this.greaterPerimeter < perimeter);
        }
        if (checkedCriteria.isEmpty()) {
            return false;
        }
        return checkedCriteria.stream().filter(b -> !b).findFirst().orElse(true);
    }
}
