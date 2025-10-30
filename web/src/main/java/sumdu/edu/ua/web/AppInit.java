package sumdu.edu.ua.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "sumdu.edu.ua")
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
        System.out.println("Started at http://localhost:8080/books");
    }
}
