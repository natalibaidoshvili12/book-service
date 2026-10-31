package ge.mziuri.bookservice.repository;

import ge.mziuri.bookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
