package sumdu.edu.ua.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sumdu.edu.ua.core.domain.Book;
import sumdu.edu.ua.core.port.CatalogRepositoryPort;
import sumdu.edu.ua.web.mail.MailService;

@Controller
@RequestMapping("/books")
public class BookFormController {
    private final MailService mailService;
    public final CatalogRepositoryPort bookRepo;

    public BookFormController(MailService mailService, CatalogRepositoryPort bookRepo) {
        this.mailService = mailService;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("bookForm", new Book());
        return "book-add";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        if (book.getTitle() != null && !book.getTitle().isBlank()) {
            bookRepo.add(book.getTitle(), book.getAuthor(), book.getPubYear());
        }

        mailService.sendNewBookEmail(book);
        return "redirect:/books";
    }
}