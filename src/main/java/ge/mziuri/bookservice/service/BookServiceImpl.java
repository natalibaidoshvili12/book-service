package ge.mziuri.bookservice.service;

import ge.mziuri.bookservice.entity.BookEntity;
import ge.mziuri.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookEntity findBook(Long id) {
        return findOr404(id);
    }

    @Override
    public BookEntity reserveBook(Long id) {
        BookEntity book = findOr404(id);
        if (book.getAvailableCopies() == 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No copies available");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }

    @Override
    public BookEntity releaseBook(Long id) {
        BookEntity book = findOr404(id);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        return bookRepository.save(book);
    }

    private BookEntity findOr404(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found"));
    }
}
