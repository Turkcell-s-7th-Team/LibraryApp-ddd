package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.book.command.CreateBookCommand;
import com.turkcell.LibraryApp_ddd.application.book.dto.BookResponse;
import com.turkcell.LibraryApp_ddd.application.book.dto.CreatedBookResponse;
import com.turkcell.LibraryApp_ddd.application.book.query.ListBooksQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final CommandHandler<CreateBookCommand, CreatedBookResponse> createHandler;
    private final QueryHandler<ListBooksQuery, List<BookResponse>> listHandler;

    public BookController(
            CommandHandler<CreateBookCommand, CreatedBookResponse> createHandler,
            QueryHandler<ListBooksQuery, List<BookResponse>> listHandler) {
        this.createHandler = createHandler;
        this.listHandler = listHandler;
    }

    @PostMapping
    public CreatedBookResponse create(@RequestBody CreateBookCommand cmd) {
        return createHandler.handle(cmd);
    }

    @GetMapping
    public List<BookResponse> list(@RequestParam(defaultValue = "0") int pageIndex,
                                   @RequestParam(defaultValue = "10") int pageSize) {
        return listHandler.handle(new ListBooksQuery(pageIndex, pageSize));
    }
}
