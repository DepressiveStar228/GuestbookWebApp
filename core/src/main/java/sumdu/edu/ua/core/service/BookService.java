package sumdu.edu.ua.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumdu.edu.ua.core.domain.Book;
import sumdu.edu.ua.core.domain.Comment;
import sumdu.edu.ua.core.port.CatalogRepositoryPort;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BookService {
    private final CatalogRepositoryPort bookRepo;

    @Transactional
    public void addCommentToBook(long bookId, String author, String text) {
        Book book = bookRepo.findById(bookId);
        if (book != null) {
            Comment comment = new Comment();
            comment.setAuthor(author);
            comment.setText(text);
            comment.setBook(book);
            comment.setCreatedAt(Instant.now());

            book.addComment(comment);
        }
    }
}
