package sumdu.edu.ua.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumdu.edu.ua.core.domain.Comment;
import java.util.List;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBookIdOrderByCreatedAtDesc(Long bookId);
    List<Comment> findByAuthorOrderByCreatedAtDesc(String author);
}
