package com.epam.jwd.task.specification;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;

import java.util.ArrayList;
import java.util.List;

public abstract class Specification implements SpecificationMatcher {

    private final String name;
    private final String startName;
    private final Color color;

    abstract static class Builder<T extends Builder<T>> {

        private String name;
        private String startName;
        private Color color;

        public T whereName(String name) {
            this.name = name;
            return self();
        }

        public T whereNameStartsWith(String startName) {
            this.startName = startName;
            return self();
        }

        public T whereColor(Color color) {
            this.color = color;
            return self();
        }

        public abstract Specification build();

        protected abstract T self();
    }

    public Specification(Builder<?> builder) {
        this.name = builder.name;
        this.startName = builder.startName;
        this.color = builder.color;
    }

    @Override
    public boolean matches(Figure figure) {
        List<Boolean> checkedCriteria = new ArrayList<>();
        if (name != null) {
            checkedCriteria.add(name.equals(figure.getName()));
        }
        if (startName != null) {
            checkedCriteria.add(figure.getName().startsWith(startName));
        }
        if (color != null) {
            checkedCriteria.add(color.equals(figure.getColor()));
        }
        if (checkedCriteria.isEmpty()) {
            return false;
        }
        return checkedCriteria.stream().filter(b -> !b).findFirst().orElse(true);
    }
}
