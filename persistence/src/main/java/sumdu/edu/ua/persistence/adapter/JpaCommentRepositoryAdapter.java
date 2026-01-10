package sumdu.edu.ua.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sumdu.edu.ua.core.domain.Book;
import sumdu.edu.ua.core.domain.Comment;
import sumdu.edu.ua.core.domain.Page;
import sumdu.edu.ua.core.domain.PageRequest;
import sumdu.edu.ua.core.port.CommentRepositoryPort;
import sumdu.edu.ua.persistence.repository.CommentJpaRepository;

import java.time.Instant;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaCommentRepositoryAdapter implements CommentRepositoryPort {
    private final CommentJpaRepository repository;

    @Override
    public void add(Book book, String author, String text) {
        Comment comment = new Comment(book, author, text, Instant.now());
        repository.save(comment);
    }

    @Override
    public Page<Comment> list(long bookId, String author, Instant since, PageRequest request) {
       var result = repository.findByBookIdOrderByCreatedAtDesc(bookId);
       return new Page<>(result, request, result.size());
    }

    @Override
    public void delete(long bookId, long commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public List<Comment> findByAuthor(String author) {
        return repository.findByAuthorOrderByCreatedAtDesc(author);
    }
}
