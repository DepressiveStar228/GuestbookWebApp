package sumdu.edu.ua.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sumdu.edu.ua.core.port.CommentRepositoryPort;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepositoryPort repo;

    @Transactional
    public void delete(long bookId, long commentId) {
        var comment = repo.list(bookId, null, null, null)
                .getItems()
                .stream()
                .filter(c -> c.getId() == commentId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        if (Duration.between(comment.getCreatedAt(), Instant.now()).toHours() > 24) {
            throw new IllegalStateException("Comment too old to delete");
        }

        repo.delete(bookId, commentId);
    }
}
