package com.turkcell.LibraryApp_ddd.core.cqrs;

public interface CommandHandler<C extends Command<R>,R> {
    R handle(C command);
}
