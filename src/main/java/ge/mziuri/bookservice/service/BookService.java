package ge.mziuri.bookservice.service;

import ge.mziuri.bookservice.entity.BookEntity;

public interface BookService {
    BookEntity releaseBook(Long id);

    BookEntity reserveBook(Long id);

    BookEntity findBook(Long id);
}
