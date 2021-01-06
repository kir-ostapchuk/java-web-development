package com.epam.jwd.task.specification;

import com.epam.jwd.task.model.Figure;

@FunctionalInterface
public interface Specification {
    
    boolean matches(Figure figure);
}
