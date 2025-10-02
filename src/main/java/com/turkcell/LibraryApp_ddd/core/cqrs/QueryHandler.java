package com.turkcell.LibraryApp_ddd.core.cqrs;

public interface QueryHandler<Q extends Query<R>,R> {
    R handle(Q query);
}
