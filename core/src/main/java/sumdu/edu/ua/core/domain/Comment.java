package sumdu.edu.ua.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    String author;

    @Column(length = 2000)
    String text;

    @Column(nullable = false)
    Instant createdAt;

    public Comment(Book book, String author, String text, Instant createdAt) {
        this.book = book;
        this.author = author;
        this.text = text;
        this.createdAt = createdAt;
    }
}
