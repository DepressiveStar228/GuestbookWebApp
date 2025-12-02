package sumdu.edu.ua.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sumdu.edu.ua.core.domain.PageRequest;
import sumdu.edu.ua.core.port.CatalogRepositoryPort;
import sumdu.edu.ua.core.port.CommentRepositoryPort;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    private final CommentRepositoryPort commentRepo;
    private final CatalogRepositoryPort bookRepo;

    public CommentsController(CommentRepositoryPort commentRepo,
                              CatalogRepositoryPort bookRepo) {
        this.commentRepo = commentRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public String list(@RequestParam long bookId, Model model) {
        var book = bookRepo.findById(bookId);
        if (book == null) return "redirect:/books";

        var comments = commentRepo
                .list(bookId, null, null, new PageRequest(0, 20))
                .getItems();

        model.addAttribute("book", book);
        model.addAttribute("comments", comments);
        model.addAttribute("commentForm", new CommentInput());
        return "book-comments";
    }

    @PostMapping
    public String add(@RequestParam long bookId, @ModelAttribute("commentForm") CommentInput commentInput) {
        commentRepo.add(bookId, commentInput.getAuthor().trim(), commentInput.getText().trim());
        return "redirect:/comments?bookId=" + bookId;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long bookId,
                         @RequestParam long commentId) {
        commentRepo.delete(bookId, commentId);
        return "redirect:/comments?bookId=" + bookId;
    }

    public static class CommentInput {
        private String author;
        private String text;

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }
}
