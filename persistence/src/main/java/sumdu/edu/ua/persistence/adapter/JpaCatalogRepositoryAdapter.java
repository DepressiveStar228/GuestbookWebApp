package sumdu.edu.ua.persistence.adapter;

import org.springframework.stereotype.Repository;
import sumdu.edu.ua.core.domain.Book;
import sumdu.edu.ua.core.domain.Page;
import sumdu.edu.ua.core.domain.PageRequest;
import sumdu.edu.ua.core.port.CatalogRepositoryPort;
import sumdu.edu.ua.persistence.repository.BookJpaRepository;

@Repository
public class JpaCatalogRepositoryAdapter implements CatalogRepositoryPort {
    private final BookJpaRepository repository;
    public JpaCatalogRepositoryAdapter(BookJpaRepository repository) { this.repository = repository; }

    @Override
    public Page<Book> search(String query, PageRequest request) {
        var pageable = org.springframework.data.domain.PageRequest.of(
                request.getPage(),
                request.getSize()
        );

        var page = repository.findAll(pageable);

        return new Page<>(
                page.getContent(),
                request,
                page.getTotalElements()
        );
    }

    @Override
    public Book findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Book add(String title, String author, int pubYear) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPubYear(pubYear);

        return repository.save(book);
    }
}
