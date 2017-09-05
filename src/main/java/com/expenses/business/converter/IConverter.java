package com.expenses.business.converter;

import java.util.Optional;

public interface IConverter<M, E> {

    Optional<E> fromModel(M model);

    Optional<M> fromEntity(E entity);
}
