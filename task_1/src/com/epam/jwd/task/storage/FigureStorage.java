package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.specification.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FigureStorage<T extends Figure> {

    boolean removeAll(T figure);

    List<T> find(T figure);

    Optional<T> findById(UUID id);

    List<T> findBySpecification(Specification specification);
}
