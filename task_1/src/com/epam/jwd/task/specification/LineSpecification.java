package com.epam.jwd.task.specification;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;

import java.util.ArrayList;
import java.util.List;

public class LineSpecification implements Specification {

    private final String name;
    private final String startName;
    private final Color color;

    private LineSpecification(String name,
                              String startName,
                              Color color) {
        this.name = name;
        this.startName = startName;
        this.color = color;
    }

    public static class Builder {

        private String name;
        private String startName;
        private Color color;

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

        public LineSpecification build() {
            return new LineSpecification(name,
                    startName,
                    color);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
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
        if (checkedCriteria.isEmpty()) {
            return false;
        }
        return checkedCriteria.stream().filter(b -> !b).findFirst().orElse(true);
    }
}
