package sumdu.edu.ua.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sumdu.edu.ua.core.port.CommentRepositoryPort;

@Controller
@RequestMapping("/users")
public class UserController {

    private final CommentRepositoryPort commentRepo;

    public UserController(CommentRepositoryPort commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping("/{username}/comments")
    public String listByUser(@PathVariable("username") String username, @RequestParam(required = false) Long fromBookId, Model model) {
        var comments = commentRepo.findByAuthor(username);

        model.addAttribute("username", username);
        model.addAttribute("comments", comments);
        model.addAttribute("fromBookId", fromBookId);

        return "user_comments";
    }
}