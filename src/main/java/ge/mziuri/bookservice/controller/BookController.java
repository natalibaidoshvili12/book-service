package ge.mziuri.bookservice.controller;

import ge.mziuri.bookservice.entity.BookEntity;
import ge.mziuri.bookservice.repository.BookRepository;
import ge.mziuri.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBook(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/reserve")
    @Transactional
    public ResponseEntity<BookEntity> reserve(@PathVariable Long id) {
        return new ResponseEntity<>(service.reserveBook(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/release")
    @Transactional
    public ResponseEntity<BookEntity> release(@PathVariable Long id) {
        return new ResponseEntity<>(service.releaseBook(id), HttpStatus.OK);
    }


}